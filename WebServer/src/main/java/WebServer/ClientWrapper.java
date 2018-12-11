package WebServer;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClientWrapper implements Runnable{
    private static final Logger log = LogManager.getLogger(ClientWrapper.class);
    private final Socket client;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private PrintWriter out;
    private Scanner in;

    public ClientWrapper(Socket client) {
        this.client = client;

        try {
            inputStream = client.getInputStream();
        } catch (IOException exc) {
            log.fatal("Error open InputStream in ClientWrapper(): " + exc.getMessage());
        }

        try {
            outputStream = client.getOutputStream();
        } catch (IOException exc) {
            log.fatal("Error open OutputStream in ClientWrapper(): " + exc.getMessage());
        }

        try {
            out = new PrintWriter(outputStream);
        } catch (Exception exc) {
            log.fatal("Error create PrintWriter in ClientWrapper(): " + exc.getMessage());
        }

        try {
            in = new Scanner(inputStream);
        } catch (Exception exc) {
            log.fatal("Error create Scanner in ClientWrapper(): " + exc.getMessage());
        }
    }


    @Override
    public void run() {
        String req = in.next();
        log.debug("req: " + req);

        if (req.equals("GET")) {
            req = in.next();
            log.debug("req: " + req);

            String fileName = null;
            FileReader reader = null;

            try {
                fileName = req.split("/")[1];
                reader = new FileReader(fileName);
            } catch (FileNotFoundException exc) {
                log.error(fileName + " not found: " + exc.getMessage());
                return;
            }
            int fileLenght = (int)(new File(fileName)).length();
            log.debug("Lenght of the fileName: " + fileLenght);
            char[] buffer = new char[fileLenght];
            try {
                reader.read(buffer);
            } catch (IOException exc) {
                log.error("Error read the file [" + fileName + "]: " + exc.getMessage());
                return;
            }

            DateFormat df = DateFormat.getTimeInstance();
            df.setTimeZone(TimeZone.getTimeZone("GMT"));

            String answer = "HTTP/1.1 200 OK\r\nContentLength: " + fileLenght + "\r\n\r\n" + (new String(buffer));
//            String answer = "HTTP/1.1 200 OK\r\n" +
//                    "ContentLength: " + fileLenght + "\r\n" +
//                    "\r\n" +
//                    "<!DOCTYPE html>\r\n" +
//                    "<html lang=\"en\">\r\n" +
//                    "<head>\r\n" +
//                    "    <meta charset=\"UTF-8\">\r\n" +
//                    "    <title>Hello</title>\r\n" +
//                    "</head>\r\n" +
//                    "<body style=\"padding: 0; margin: 0; width: 100%; height: 100%\">\r\n" +
//                    " <h3 style=\"margin-left:150px; margin-top: 150px;\">Hello</h3>\r\n" +
//                    "</body>\r\n" +
//                    "</html>\r";
            log.debug("answer = " + answer);

            out.println(answer);
            out.flush();
            try {
                client.close();
            } catch (IOException exc) {
                log.debug("Error close client socket: " + exc.getMessage());
            }
        }
    }
}
