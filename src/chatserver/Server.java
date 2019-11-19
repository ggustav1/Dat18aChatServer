package chatserver;
import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serversock;
    private Socket              sock;
    private DataInputStream inputStream;
    private ArrayList<ChatClient> clients;

    public Server(int port) {
    }

    public static void main(String[] args) {
        System.out.println("hejsa");
    }

    /**
     *  Getters & setters
     */
    public ServerSocket getServersock() {
        return serversock;
    }

    public void setServersock(ServerSocket serversock) {
        this.serversock = serversock;
    }

    public ArrayList<ChatClient> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ChatClient> clients) {
        this.clients = clients;
    }
}
