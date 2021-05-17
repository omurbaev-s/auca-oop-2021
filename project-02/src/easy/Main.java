package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    CanvasPanel mainPanel;

    GameModel game;
    Images images;

    Main() throws Exception{
        game = new GameModel();
        images = new Images();
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.addKeyListener(new CanvasPanelListener());

        setTitle("Sokoban");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args){
        try {
            new Main();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int widthCell = images.ground.getWidth();
            int heightCell = images.ground.getHeight();

            int xLeftUpper = getWidth()/2 - widthCell*game.maze.getWidth()/2;
            int yLeftUpper = getHeight()/2 - heightCell*game.maze.getHeight()/2;

            for (int r = 0; r < game.maze.getHeight(); r++) {
                for (int c = 0; c < game.maze.getWidth(); c++) {
                    switch (game.maze.get(r, c)) {
                        case ' ':
                            drawImage(g, images.ground,
                                    xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell );
                            break;
                        case '#':
                            drawImage(g, images.wall,
                                    xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell);
                            break;
                    }
                }
            }
            for(int i=0; i<game.maze.exits.size(); i++) {
                drawImage(g, images.goal,
                        xLeftUpper + game.maze.exits.get(i).getExitCol() * widthCell,
                        yLeftUpper + game.maze.exits.get(i).getExitRow() * heightCell,
                        widthCell, heightCell);
            }

            drawImage(g, images.robot,
                    xLeftUpper+game.maze.getRobotCol()*widthCell,
                    yLeftUpper+game.maze.getRobotRow()*heightCell,
                    widthCell,heightCell);
         }

        private void drawImage(Graphics g, BufferedImage img, int x, int y, int width, int height) {
            int leftX = x + width / 2 - img.getWidth() / 2;
            int leftY = y + height /2 - img.getHeight() / 2;
            g.drawImage(img,leftX,leftY,null);
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
