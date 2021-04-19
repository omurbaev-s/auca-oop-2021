package p08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    CanvasPanel mainPanel;

    Main(){
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        add(mainPanel, BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            int widthCell = Math.round(getWidth() / 8f);
            int heightCell = Math.round(getHeight() / 8f);
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {  
                    if ((r % 2 == 0 && c%2==0) || (r%2!=0 && c%2!=0)) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(c * widthCell, r * heightCell, widthCell, heightCell);
                }
            }
        }
    }
}
