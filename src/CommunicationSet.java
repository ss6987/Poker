import java.io.*;
import java.net.Socket;

/**
 * Created by SS on 2016/12/20.
 */
public class CommunicationSet {

    private static Socket socket;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;

    public CommunicationSet(Socket socket) throws IOException {
        this.socket = socket;
        oos = new ObjectOutputStream(this.socket.getOutputStream());
        ois = new ObjectInputStream(this.socket.getInputStream());
    }

    public void authorization(boolean flag){
        try {
            oos.writeBoolean(flag);
            oos.flush();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public ObjectOutputStream getOos(){
        return this.oos;
    }

    public ObjectInputStream getOis(){
        return this.ois;
    }
}
