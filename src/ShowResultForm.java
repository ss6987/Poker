import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ShowResultForm extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel[] playerPanel = new JPanel[5];
    private JPanel[] playerNamePanel = new JPanel[5];
    private JPanel[] playerHandPanel = new JPanel[5];
    private JPanel[] cardPanel = new JPanel[25];
    private JLabel[] playerNameLabel = new JLabel[5];
    private JLabel[] cardLabel = new JLabel[25];

    public ShowResultForm(int playerId , PlayerType[] playerList) {
        DecisionUnit judgeResult = new DecisionUnit(playerList);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int playerNumber = 0; playerNumber < playerList.length; playerNumber++) {
            playerNameLabel[playerNumber] = new JLabel();
            playerNamePanel[playerNumber] = new JPanel();
            playerPanel[playerNumber] = new JPanel();
            playerNameLabel[playerNumber].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 24));
            if (judgeResult.getWinner()[playerNumber]) {
                playerNameLabel[playerNumber].setForeground(Color.red);
            }
            playerNamePanel[playerNumber].add(playerNameLabel[playerNumber]);
            createHandPanel(playerNumber, playerList[playerNumber]);
            playerPanel[playerNumber].setLayout(new BoxLayout(playerPanel[playerNumber], BoxLayout.Y_AXIS));
            playerPanel[playerNumber].add(playerNamePanel[playerNumber]);
            playerPanel[playerNumber].add(playerHandPanel[playerNumber]);
            playerNameLabel[playerNumber].setText("player" + playerNumber + "   " + judgeResult.getJudgeResult()[playerNumber].pokerRankingString());
            mainPanel.add(playerPanel[playerNumber]);
        }
        setTitle("結果発表(あなたはplayer"+playerId+")");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void createHandPanel(int playerNumber, PlayerType player) {
        playerHandPanel[playerNumber] = new JPanel();
        playerHandPanel[playerNumber].setLayout(new BoxLayout(playerHandPanel[playerNumber], BoxLayout.X_AXIS));
        for (int cardNumber = 0; cardNumber < 5; cardNumber++) {
            cardLabel[playerNumber * 5 + cardNumber] = new JLabel();
            cardLabel[playerNumber * 5 + cardNumber].setIcon(new ImageIcon("./img/" + player.getHand().getHandCard(cardNumber).getMark() + "_" + player.getHand().getHandCard(cardNumber).getNumber() + ".png"));
            cardPanel[playerNumber * 5 + cardNumber] = new JPanel();
            cardPanel[playerNumber * 5 + cardNumber].add(cardLabel[playerNumber * 5 + cardNumber]);
            playerHandPanel[playerNumber].add(cardPanel[playerNumber * 5 + cardNumber]);
        }
    }
}
