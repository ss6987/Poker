import java.io.*;
import java.net.Socket;

public class CommunicationSet {
    private Socket socket = new Socket();
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public CommunicationSet(Socket socket) throws IOException {
        this.socket = socket;
        oos = new ObjectOutputStream(this.socket.getOutputStream());
        ois = new ObjectInputStream(this.socket.getInputStream());
    }

    public Socket getSocket() {
        return this.socket;
    }

    public ObjectOutputStream getOos() {
        return this.oos;
    }

    public ObjectInputStream getOis() {
        return this.ois;
    }

}
