import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by SS on 2017/01/05.
 */
public class DecideAddPlayerForm extends JFrame {
    private JButton button1;
    private JButton button2;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;

    public DecideAddPlayerForm(PokerClient pokerClient) {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextPage(pokerClient,true);
                super.mouseClicked(e);
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                nextPage(pokerClient,false);
                super.mouseClicked(e);}

        });
        setTitle("playerを追加するか選択してください");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void nextPage(PokerClient pokerClient,Boolean flag){
        pokerClient.gameStart(flag);
        try {
            pokerClient.loadHand();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        new ShowPlayerHandForm(pokerClient);
        setVisible(false);
    }

}
