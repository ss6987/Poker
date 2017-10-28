/**
 * Created by SS on 2016/12/02.
 */

import java.io.IOException;
import java.net.*;
import java.lang.*;
import java.util.ArrayList;

public class PokerServer {

    private static DeckType deck = new DeckType();
    private static ArrayList<PlayerType> player = new ArrayList<>();
    private static ServerSocket serverSocket = null;
    private static CommunicationSet connect = null;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(5001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createPlayer();
        sendHand();
        changeCard();
        sendFinalHand();
    }

    private static void createPlayer() {
        try {
            boolean addFlag = true;
            int playerNumber = 0;
            while (addFlag == true && playerNumber < 5) {
                connect = new CommunicationSet(serverSocket.accept());
                if (checkPhase(0)) {
                    addFlag = connect.getOis().readBoolean();
                    player.add(new PlayerType(deck));
                    connect.getOos().writeInt(playerNumber);
                    connect.getOos().flush();
                    playerNumber++;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    private static void sendHand() {
        try {
            int playerNumber = 0;
            while (playerNumber < player.size()) {
                connect = new CommunicationSet(serverSocket.accept());
                if (checkPhase(1)) {
                    connect.getOos().writeObject(player.get(connect.getOis().readInt()));
                    connect.getOos().flush();
                    connect.getOos().writeInt(player.size());
                    connect.getOos().flush();
                    playerNumber++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void changeCard() throws IOException {
        int playerNumber = 0;
        while (playerNumber < player.size()) {
            connect = new CommunicationSet(serverSocket.accept());
            try {
                if (checkPhase(2)) {
                    int playerId = connect.getOis().readInt();
                    RequestType request = (RequestType) connect.getOis().readObject();
                    player.get(playerId).drawHand(deck, request);
                    connect.getOos().writeObject(player.get(playerId));
                    connect.getOos().flush();
                    playerNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendFinalHand() throws IOException {
        int playerNumber = 0;
        while (playerNumber < player.size()) {
            connect = new CommunicationSet(serverSocket.accept());
            if (checkPhase(3)) {
                for (int j = 0; j < player.size(); j++) {
                    int requestPlayer = connect.getOis().readInt();
                    connect.getOos().writeObject(player.get(requestPlayer));
                    connect.getOos().flush();
                }
                playerNumber++;
            }
        }
    }

    private static Boolean checkPhase(int phase) throws IOException {
        if (connect.getOis().readInt() == phase) {
            connect.getOos().writeBoolean(true);
            connect.getOos().flush();
            return true;
        } else {
            connect.getOos().writeBoolean(false);
            connect.getOos().flush();
            return false;
        }
    }
}