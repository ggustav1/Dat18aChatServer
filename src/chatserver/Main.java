package chatserver;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server s = new Server(2000);


        ChatClient cc = new ChatClient(2000, "john");
        cc.run();
        ChatClient cc1 = new ChatClient(2000, "john");
        ChatClient cc2 = new ChatClient(2000, "john");
        try {
            s.run();
            System.out.println("bla");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
