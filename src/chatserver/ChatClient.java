package chatserver;
import java.io.*;
import java.net.Socket;

public class ChatClient implements Runnable{
    private String host;
    private int    serverport;
    private String username;
    private Socket sock;
    private InputStream     instream;
    private OutputStream    outstream;
    private BufferedReader  reader;

    public ChatClient(String host, int serverport, String username) {
        this.host = host;
        this.serverport = serverport;
        this.username = username;
        this.host = host;

        try {
            this.sock = new Socket(host, serverport);
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
        System.out.println("Test");
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
