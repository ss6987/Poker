/**
 * Created by SS on 2016/12/05.
 */

//import java.io.*;
//import java.io.IOException;
//import java.net.Socket;
//import java.net.UnknownHostException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PokerClient {

    private static String server = "localhost";
    private static int port = 5001;
    private static Socket socket;
    private static InputStream is;

    public static void main(String[] args) throws InterruptedException {
        HandType hand = gameStart();

        RequestType request = new RequestType(createRequest(hand));

    }

    private static HandType gameStart(){
        try{
            socket = new Socket(server,port);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            System.out.println("人を追加=0,受付終了=1");
            oos.writeInt(Integer.parseInt(scanString()));
            oos.flush();

            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            while(ois.readBoolean() == false){
                System.out.println("待機中");
            }
            System.out.println("待機終了");
            HandType hand = (HandType) ois.readObject();
            oos.close();
            return hand;
        }catch (Exception e){
            System.out.println("Exception" + e);
        }
        return null;
    }



    private static void sendRequest(RequestType request){

    }




    private static int[] createRequest(HandType hand) {
        int[] request_int;
        for (int i = 0; i < 5; i++) {
            System.out.println(hand.getHandCard(i).getNumber() + "," + hand.getHandCard(i).getMarkString());
        }
        System.out.println("入れ替える手札を1～5,カンマ区切りで指定してください。");
        request_int = analyzeString();
        return request_int;
    }

    private static int[] analyzeString() {
        String str = scanString();
        String[] list = str.split(",", 0);
        int[] int_list = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            int_list[i] = Integer.parseInt(list[i]) - 1;
        }
        return int_list;
    }

    private static String scanString() {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        return str;
    }

}
