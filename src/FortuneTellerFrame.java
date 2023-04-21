import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl, topPnl, centerPnl, bottomPnl;
    JButton quitBtn, fortuneBtn;
    TextArea fortuneTA;
    JScrollPane pane;
    JLabel iconLbl;
    ImageIcon fortuneIcon;

    String[] fortunes = {"You will experience something weird tomorrow", "Your parents will come across something great", "Something tasty you will eat", "Something important will get stuck tomorrow", "You will come across something valueable", "Your lucky numbers are 1, 5, 9, 13, 34, and 56", "Today you will make somebodys day", "Error 404 Fortune not found", "You are not illiterate", "You will be hungry again in 1 hour", "Ignore previous fortune", "You will do someone A favor"};
    String computersChoice = "";
    int currentFortuneNum = 1;
    int oldValue = 1;


    public FortuneTellerFrame() {
        createGUI();
        setTitle("Fortune Teller");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI() {
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();
    }

    private void createTopPnl() {
        fortuneIcon = new ImageIcon("src\\fortuneTeller.jpg");
        iconLbl = new JLabel("Read your fortune!", fortuneIcon, JLabel.CENTER);
        topPnl.add(iconLbl);
        iconLbl.setFont(new Font("Arial", Font.BOLD, 22));
        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);
    }

    private void createCenterPnl() {
        fortuneTA = new TextArea(15, 50);
        pane = new JScrollPane(fortuneTA);
        centerPnl.add(pane);

    }

    private void createBottomPnl() {
        fortuneBtn = new JButton("Get a Fortune");
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        fortuneBtn.addActionListener((ActionEvent ae) -> {
            RandomStrategy();
        });


        bottomPnl.setLayout(new GridLayout(1, 2));
        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
    }

    private void RandomStrategy() {
        Random rand = new Random();

        while  (currentFortuneNum == oldValue)
            {
                currentFortuneNum = rand.nextInt(12);
            }
        oldValue = currentFortuneNum;


        String response = "";
        response = fortunes[currentFortuneNum];

        fortuneTA.append(response + "\n");
    }
}
