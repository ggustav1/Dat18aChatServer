package chatserver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        Server s = new ServerImpl(2000);
        s.start();
    }

    public static void main2(String[] args) {
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            Socket sock = new Socket(ip, 2000);
            Client c = new SimpleClientImpl(sock);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
