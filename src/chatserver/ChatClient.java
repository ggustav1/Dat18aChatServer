package chatserver;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient implements Runnable{
    private InetAddress hostip;
    private int    serverport;
    private String username;
    private Socket sock;
    private InputStream     instream;
    private OutputStream    outstream;
    private BufferedReader  reader;

    public ChatClient(int serverport, String username) {
        try {
            this.hostip = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.serverport = serverport;
        this.username = username;
        try {
            this.sock = new Socket(this.hostip, serverport);
            this.outstream = sock.getOutputStream();
            this.instream = sock.getInputStream();
            this.reader = new BufferedReader(new InputStreamReader(this.instream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLine(){
        String line = "";

        try {
            line = this.reader.readLine(); // reads a line of text
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    @Override
    public void run() {

    }
    public int getServerport() {
        return serverport;
    }

    public void setServerport(int serverport) {
        this.serverport = serverport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Socket getSock() {
        return sock;
    }

    public void setSock(Socket sock) {
        this.sock = sock;
    }

}
