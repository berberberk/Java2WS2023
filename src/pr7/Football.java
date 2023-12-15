package pr7;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Football extends JFrame {
    int milanCnt = 0;
    int madridCnt = 0;
    JButton milan = new JButton(" AC Milan ");
    JButton madrid = new JButton("Real Madrid");
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel lastScorer = new JLabel("Last Scorer: N/A");
    Label winner = new Label("Winner: DRAW");

    Font fnt1 = new Font("Times new roman", Font.BOLD, 40);
    Font fnt2 = new Font("Serif", Font.BOLD, 40);

    public Football() {
        super("Football Game");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        milan.setFont(fnt1);
        madrid.setFont(fnt1);
        result.setFont(fnt1);
        lastScorer.setFont(fnt1);
        winner.setFont(fnt2);
        milan.setBorderPainted(true);
        milan.setBorder(new LineBorder(Color.red, 5));
        milan.setFocusPainted(false);
        milan.setBackground(Color.BLACK);
        milan.setForeground(Color.RED);
        madrid.setBorderPainted(true);
        madrid.setBorder(new LineBorder(Color.black, 5));
        madrid.setFocusPainted(false);
        madrid.setBackground(Color.WHITE);
        madrid.setForeground(Color.YELLOW);
        add(milan);
        add(madrid);
        add(result);
        add(lastScorer);
        add(winner);
        milan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanCnt++;
                result.setText("Result: " + milanCnt + " X " + madridCnt);
                lastScorer.setText("Last Scorer: AC Milan");
                if (milanCnt == madridCnt)
                    winner.setText("Winner: DRAW");
                else if (milanCnt > madridCnt)
                    winner.setText("Winner: AC Milan");
                else
                    winner.setText("Winner: Real Madrid");
            }
        });
        madrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridCnt++;
                result.setText("Result: " + milanCnt + " X " + madridCnt);
                lastScorer.setText("Last Scorer: Real Madrid");
                if (milanCnt == madridCnt)
                    winner.setText("Winner: DRAW");
                else if (milanCnt > madridCnt)
                    winner.setText("Winner: AC Milan");
                else
                    winner.setText("Winner: Real Madrid");
            }
        });
    }

    public static void main(String[] args) {
        new Football().setVisible(true);
    }
}
