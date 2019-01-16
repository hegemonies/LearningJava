package WebServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClientWrapper implements Runnable {
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
            outputStream = client.getOutputStream();
            out = new PrintWriter(outputStream);
            in = new Scanner(inputStream);
        } catch (IOException exc) {
            log.fatal("Error in ClientWrapper(): " + exc.getMessage());
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

            // DateFormat df = DateFormat.getTimeInstance();
            // df.setTimeZone(TimeZone.getTimeZone("GMT"));

            String answer = "HTTP/1.1 200 OK\r\nContentLength: " + fileLenght + "\r\n\r\n" + (new String(buffer));

            // log.debug("answer = " + answer);

            out.println(answer);
            out.flush();

            try {
                client.close();
                reader.close();
            } catch (IOException exc) {
                log.debug("Error close client socket: " + exc.getMessage());
            }
        }
    }
}
