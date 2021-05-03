package help01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            int xLeftUpper = getWidth()/4;
            int yLeftUpper = getHeight()/4;
            int widthCell = Math.round(getWidth() /2f/ game.maze.getWidth());
            int heightCell = Math.round(getHeight() /2f/ game.maze.getHeight());
            for (int r = 0; r < game.maze.getHeight(); r++) {
                for (int c = 0; c < game.maze.getWidth(); c++) {
                    Color curColor = game.maze.getCurElement(r,c) == '#' ? Color.DARK_GRAY: Color.GREEN;
                    g.setColor(curColor);
                    g.fillRect(xLeftUpper+c * widthCell, yLeftUpper+r * heightCell, widthCell, heightCell);
                    g.setColor(Color.BLACK);
                    g.drawRect(xLeftUpper+c * widthCell, yLeftUpper+r * heightCell, widthCell, heightCell);
                }
            }

            g.setColor(Color.YELLOW);
            g.fillOval(xLeftUpper+game.maze.getExitCol()*widthCell,yLeftUpper+game.maze.getExitRow()*heightCell, widthCell,heightCell);
            g.setColor(Color.RED);
            g.fillOval(xLeftUpper+game.maze.getRobotCol()*widthCell,yLeftUpper+game.maze.getRobotRow()*heightCell, widthCell,heightCell);
        }
    }
    class CanvasPanelListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_F1){
                JOptionPane.showMessageDialog(null,"Move robot using arrows!!!");
            } else if(e.getKeyCode()==KeyEvent.VK_UP){
                game.maze.move(-1,0);
            } else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                game.maze.move(1,0);
            } else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                game.maze.move(0,-1);
            } else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                game.maze.move(0,1);
            }
            repaint();
            if(game.maze.isWin()){
                JOptionPane.showMessageDialog(Main.this, String.format("Maze %s solved", game.getCurLvl()));
                game.nextLevel();
                repaint();
            }
        }
    }
}
