package chatserver;

public class Main {
    public static void main(String[] args) {

        ServerImpl server = new ServerImpl(2000);

        server.start();
    }
}
