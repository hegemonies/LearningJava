import WebServer.WebServer;

public class Main {
    private final static int port = 8080;
    public static void main(final String... args) {
        new WebServer(port).Up();
    }
}
