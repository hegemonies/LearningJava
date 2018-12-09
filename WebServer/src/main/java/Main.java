import WebServer.WebServer;

public class Main {
    private final static int port = 50000;
    public static void main(final String... args) {
        WebServer ws = new WebServer(port);
        ws.Up();
    }
}
