package chatserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

    public static void main(String[] args) {
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            Socket sock = new Socket(ip, 2000);
            Client c = new SimpleClientImpl(sock);

            SimpleClientImpl simpleClient = new SimpleClientImpl(sock);

            simpleClient.send(simpleClient, "Gus");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
