import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by SS on 2017/01/05.
 */
public class ShowPlayerHandForm extends JFrame {
    private JLabel cardLabel0;
    private JLabel cardLabel1;
    private JLabel cardLabel2;
    private JLabel cardLabel3;
    private JLabel cardLabel4;
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label0;
    private JPanel cardpanel0;
    private JPanel cardpanel4;
    private JPanel cardpanel1;
    private JPanel cardpanel2;
    private JPanel cardpanel3;
    private JButton Button１;
    private JLabel label1;
    private boolean[] flag = {false,false,false,false,false};

    public ShowPlayerHandForm(PokerClient pokerClient) {
        label0.setText("You are Player" + pokerClient.getPlayerId());
        changeCards(pokerClient.getPlayerHand());
        setTitle("入れ替える手札を選択してください");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel0);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cardLabel0.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                changeFlag(0);
                changeCards(pokerClient.getPlayerHand());
                super.mouseClicked(e);
            }
        });

        cardLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFlag(1);
                changeCards(pokerClient.getPlayerHand());
                super.mouseClicked(e);
            }
        });

        cardLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFlag(2);
                changeCards(pokerClient.getPlayerHand());
                super.mouseClicked(e);
            }
        });

        cardLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFlag(3);
                changeCards(pokerClient.getPlayerHand());
                super.mouseClicked(e);
            }
        });

        cardLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeFlag(4);
                changeCards(pokerClient.getPlayerHand());
                super.mouseClicked(e);
            }
        });

        Button１.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RequestType request = new RequestType(flag);
                try {
                    pokerClient.sendRequest(request);
                    changeCards(pokerClient.getPlayerHand());
                    Button１.setVisible(false);
                    new ShowResultForm(pokerClient.getPlayerId(), pokerClient.showResult());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
                super.mouseClicked(e);
            }
        });
    }

    private void changeFlag(int buttonNumber){
        if (flag[buttonNumber]) {
            flag[buttonNumber] = false;
        } else {
            flag[buttonNumber] = true;
        }

    }

    private void changeCards(HandType hand) {
        if(this.flag[0]){
            cardLabel0.setIcon(new ImageIcon("./img/back.png"));
        }else{
            cardLabel0.setIcon(new ImageIcon("./img/" + hand.getHandCard(0).getMark() + "_" + hand.getHandCard(0).getNumber() + ".png"));
        }
        if(this.flag[1]){
            cardLabel1.setIcon(new ImageIcon("./img/back.png"));
        }else{
            cardLabel1.setIcon(new ImageIcon("./img/" + hand.getHandCard(1).getMark() + "_" + hand.getHandCard(1).getNumber() + ".png"));
        }
        if(this.flag[2]){
            cardLabel2.setIcon(new ImageIcon("./img/back.png"));
        }else{
            cardLabel2.setIcon(new ImageIcon("./img/" + hand.getHandCard(2).getMark() + "_" + hand.getHandCard(2).getNumber() + ".png"));
        }
        if(this.flag[3]){
            cardLabel3.setIcon(new ImageIcon("./img/back.png"));
        }else{
            cardLabel3.setIcon(new ImageIcon("./img/" + hand.getHandCard(3).getMark() + "_" + hand.getHandCard(3).getNumber() + ".png"));
        }
        if(this.flag[4]){
            cardLabel4.setIcon(new ImageIcon("./img/back.png"));
        }else{
            cardLabel4.setIcon(new ImageIcon("./img/" + hand.getHandCard(4).getMark() + "_" + hand.getHandCard(4).getNumber() + ".png"));
        }
    }
}
