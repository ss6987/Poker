/**
 * Created by SS on 2016/12/02.
 */

import java.net.*;
import java.lang.*;
import java.util.ArrayList;

public class PokerServer {

    private static DeckType deck = new DeckType();
    private static ArrayList<PlayerType> player = new ArrayList<PlayerType>();
    private static CommunicationSet connect[] = new CommunicationSet[5];
    private static ServerSocket ss = null;

    public static void main(String[] args) {
        System.out.println("test");
        createPlayer();
        for(int k = 0; k < 5; k++){
            connect[k].authorization(true);
        }

        for (int i = 0; i < player.size(); i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(player.get(i).getHand().getHandCard(j).getNumber() + "," + player.get(i).getHand().getHandCard(j).getMarkString());

            }
            System.out.println(player.get(i).getJudgeResult().pokerRankingString());
        }
    }

    private static void changeCard() {

    }

    private static void createPlayer() {
        try {
            int port = 5001;
            int req = 0;
            int playerNumber = 0;
            ss = new ServerSocket(5001);
            while (req == 0 && playerNumber < 5) {
                connect[playerNumber] = new CommunicationSet(ss.accept());
                player.add(new PlayerType(deck));
                System.out.println("接続");
                req = connect[playerNumber].getOis().readInt();
                connect[playerNumber].authorization(false);
                playerNumber = playerNumber + 1;
            }
            System.out.println("脱ループ");

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

}