package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    public GUI(){

        JFrame frame = new JFrame();

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(this);

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(startButton);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Solitaire");
        frame.pack();
        frame.setVisible(true);



    }

    Integer count = 0;
    JLabel label = new JLabel("Number of clicks: 0");
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }

}
