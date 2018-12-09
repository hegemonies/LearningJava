package WebServer;

import org.apache.logging.log4j.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final Logger log = LogManager.getLogger(WebServer.class);
    private ServerSocket socket;
    private int port;

    public WebServer(int port) {
        this.port = port;
    }

    public void Up() {
        try {
            socket = new ServerSocket(port);
            log.info("Server upped");
            this.Run();
        } catch (IOException exc) {
            log.fatal("Can't up the server: " + exc.getMessage());
        }
    }

    private void Run() {
        while (true) {
            try {
                Socket client = socket.accept();

                log.info("New connect: " + client.toString());

                Runnable runnable = new ClientWrapper(client);
                Thread thread = new Thread(runnable);
                thread.start();
            } catch (IOException exc) {
                log.error("Error accept client socket in Run(): " + exc.getMessage());
            }
        }
    }
}
