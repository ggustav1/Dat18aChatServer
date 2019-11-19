package chatserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serversock;
    private DataInputStream inputStream;
    private ArrayList<ChatClient> clients;

    public Server(int port) {
        try {
            this.serversock = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*

    public ServerSocket getServersock() { return serversock; }

    public void setServersock(ServerSocket serversock) {this.serversock = serversock;}

    public ArrayList<ChatClient> getClients() { return clients; }

    public void setClients(ArrayList<ChatClient> clients) {this.clients = clients;}

    */

    public void run() throws IOException {
        while(true) {

            Socket socket = null;

            try {
                // socket object modtager klient anmodninger
                socket = serversock.accept();

                System.out.println("En ny klient har tilsluttet sig" + socket);

                // modtag input og output stream
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Tildeler ny tråd til denne klient");

                //Opret ny tråd til objekt
                Thread thread = new ClientHandler(dataInputStream, dataOutputStream, socket);

                // Invoke start() metoden
                thread.start();

            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {

    final DataInputStream  dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket socket;

    ClientHandler(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Socket socket) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.socket = socket;
    }

    @Override
    public void run() {
        String modtaget;
        String klarTilRetur;

        // Kør uendeligt loop
        while (true) {
            try {

                // Modtag svar fra klient
                modtaget = dataInputStream.readUTF();

                if (modtaget.equals("QUIT")) {
                    System.out.println("Klient " + this.socket + "har forladt chatten");
                    this.socket.close();
                    System.out.println("Forbindelse lukket");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                // lukker rescourser
                this.dataInputStream.close();
                this.dataOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
