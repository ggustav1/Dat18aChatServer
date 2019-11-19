package chatserver;
import java.net.Socket;

public class ChatClient implements Runnable{
    private String username;
    private Socket sock;


    @Override
    public void run() {
        System.out.println("Test");
    }
}
