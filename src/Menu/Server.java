package Menu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static ArrayList<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(8000);
        //while (true) {

        Socket socket = serverSocket.accept();
        System.out.println("new one added!");
        sockets.add(socket);

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        ClientInfo object = (ClientInfo) objectInputStream.readObject();

        //System.out.println(object.getName());
        //}
    }
}
