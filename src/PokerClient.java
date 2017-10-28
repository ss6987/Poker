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

    private PlayerType player;
    private CommunicationSet connect;
    private int playerId;
    private int playerSize;
    private String address;

    public void gameStart(boolean addFlag) {
        try {
            connectServer(0);
            connect.getOos().writeBoolean(addFlag);
            connect.getOos().flush();
            playerId = connect.getOis().readInt();
            connect.getSocket().close();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

    public void loadHand() throws IOException, InterruptedException, ClassNotFoundException {
        connectServer(1);
        connect.getOos().writeInt(playerId);
        connect.getOos().flush();
        player = (PlayerType) connect.getOis().readObject();
        playerSize = connect.getOis().readInt();
        connect.getSocket().close();
    }

    public void sendRequest(RequestType request) throws IOException, InterruptedException, ClassNotFoundException {
        connectServer(2);
        connect.getOos().writeInt(playerId);
        connect.getOos().flush();
        connect.getOos().writeObject(request);
        connect.getOos().flush();
        player = (PlayerType) connect.getOis().readObject();
        connect.getSocket().close();
    }

    public PlayerType[] showResult() throws IOException, InterruptedException, ClassNotFoundException {
        connectServer(3);
        PlayerType[] playerList = new PlayerType[playerSize];
        for (int playerNumber = 0; playerNumber < playerSize; playerNumber++) {
            connect.getOos().writeInt(playerNumber);
            connect.getOos().flush();
            playerList[playerNumber] = (PlayerType) connect.getOis().readObject();
        }
        connect.getSocket().close();
        return playerList;
    }

    public void connectServer(int connectNumber) throws InterruptedException, IOException {
        int counter = 0;
        do {
            if (counter != 0) {
                Thread.sleep(10000);
            }
            connect = new CommunicationSet(new Socket(address, 5001));

            connect.getOos().writeInt(connectNumber);
            connect.getOos().flush();
            counter++;
        } while (connect.getOis().readBoolean() == false);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HandType getPlayerHand() {
        return player.getHand();
    }

    public int getPlayerId() {
        return playerId;
    }
}
