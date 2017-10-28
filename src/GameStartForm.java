import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameStartForm extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JTextField textBox1;
    private JLabel label1;
    private JButton startButton;
    private PokerClient pokerClient = new PokerClient();

    public static void main(String[] args) {
        new GameStartForm();
    }

    public GameStartForm() {
        startButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ("".equals(textBox1.getText())) {
                    pokerClient.setAddress("localhost");
                } else {
                    pokerClient.setAddress(textBox1.getText());
                }
                new DecideAddPlayerForm(pokerClient);
                setVisible(false);
                super.mouseClicked(e);
            }
        });
        setTitle("GameStart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}

