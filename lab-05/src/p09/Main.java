package p09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    CanvasPanel mainPanel;

    GameModel game = new GameModel();

    Main(){
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.addKeyListener(new CanvasPanelListener());

    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
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

            g.setColor(Color.RED);
            g.fillOval(game.getCol()*widthCell,game.getRow()*heightCell, widthCell,heightCell);
        }
    }
    class CanvasPanelListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_F1){
                JOptionPane.showMessageDialog(null,"Move robot using arrows!!!");
            } else if(e.getKeyCode()==KeyEvent.VK_UP){
                game.moveUp();
            } else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                game.moveDown();
            } else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                game.moveLeft();
            } else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                game.moveRight();
            }
            repaint();
        }
    }
}
