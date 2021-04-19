package p03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    JPanel mainPanel;
    JPanel controlPanel;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    Main(){
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.darkGray);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.SOUTH);

        redButton.addActionListener(new ButtonListener(Color.RED));
        greenButton.addActionListener(new ButtonListener( Color.GREEN));
        blueButton.addActionListener(new ButtonListener(Color.BLUE));
    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("First GUI App");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    class ButtonListener implements ActionListener{
        // Main frame;
        Color color;

        public  ButtonListener(/*Main frame,*/ Color color){
            //this.frame=frame;
            this.color=color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            /*frame.*/mainPanel.setBackground(color);
        }
    }
}
