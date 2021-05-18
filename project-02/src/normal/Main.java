package normal;

import javax.swing.Box;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    CanvasPanel mainPanel;
    JPanel controlPanel;
    GameModel game;
    Images images;
    JLabel levl = new JLabel("Level");
    JLabel puzzle = new JLabel("Puzzle");
    JLabel move = new JLabel("Moves");

    JButton mini = new JButton("Minicosmos");
    JButton level = new JButton();
    JButton prevLevel = new JButton("<<");
    JButton nextLevel = new JButton(">>");
    JButton moves = new JButton();
    JButton reset = new JButton("Reset(Esc)");
    JButton undo = new JButton("Undo(PgUp)");
    JButton redo = new JButton("Redo(PgDn)");


    Main() throws Exception{
        game = new GameModel();
        images = new Images();
        setLayout(new BorderLayout());
        levl.setForeground(Color.YELLOW);
        puzzle.setForeground(Color.YELLOW);
        move.setForeground(Color.YELLOW);

        mainPanel = new CanvasPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.addKeyListener(new CanvasPanelListener());

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.setFocusable(true);
        controlPanel.requestFocus();
        controlPanel.add(levl);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(mini);
        controlPanel.add(puzzle);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(level);
        controlPanel.add(Box.createRigidArea(new Dimension(100,10)));
        controlPanel.add(prevLevel);
        controlPanel.add(Box.createRigidArea(new Dimension(100,10)));
        controlPanel.add(nextLevel);
        controlPanel.add(move);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(moves);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(reset);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(undo);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(redo);
        controlPanel.setPreferredSize(new Dimension(150,100));
        add(controlPanel, BorderLayout.EAST);
        mini.setBackground(Color.CYAN);
        level.setBackground(Color.CYAN);
        moves.setBackground(Color.CYAN);
        mini.setPreferredSize(new Dimension(120, 40));
        level.setPreferredSize(new Dimension(120, 40));
        moves.setPreferredSize(new Dimension(120, 40));
        reset.setPreferredSize(new Dimension(120, 40));
        undo.setPreferredSize(new Dimension(120, 40));
        redo.setPreferredSize(new Dimension(120, 40));
        nextLevel.setPreferredSize(new Dimension(120, 40));
        prevLevel.setPreferredSize(new Dimension(120, 40));

        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                game.reset();
                repaint();
                mainPanel.setFocusable(true);
                mainPanel.requestFocus();
            }
        });

        setTitle("Sokoban");
        setSize(1000,800);
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
            setBackground(Color.BLACK);
            level.setText(String.valueOf(game.getCurLvl()));
            moves.setText(String.valueOf(game.maze.getMoves()));

            int widthCell = images.ground.getWidth();
            int heightCell = images.ground.getHeight();

            int xLeftUpper = getWidth()/2 - widthCell*game.maze.getWidth()/2-widthCell;
            int yLeftUpper = getHeight()/2 - heightCell*game.maze.getHeight()/2;

            for (int r = 0; r < game.maze.getHeight(); r++) {
                for (int c = 0; c < game.maze.getWidth(); c++) {
                    switch (game.maze.get(r, c)) {
                        case ' ':
                            drawImage(g, images.ground,
                                    xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell );
                            break;
                        case '#':
                            drawImage(g, images.ground,
                                    xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell );
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
            for(int i=0; i<game.maze.boxes.size(); i++){
                if(game.maze.exits.contains(new Exit(game.maze.boxes.get(i).getBRow(),game.maze.boxes.get(i).getBCol()))) {
                    drawImage(g, images.ground,
                            xLeftUpper + game.maze.boxes.get(i).getBCol() * widthCell,
                            yLeftUpper + game.maze.boxes.get(i).getBRow() * heightCell,
                            widthCell, heightCell );
                    drawImage(g, images.rBox,
                            xLeftUpper + game.maze.boxes.get(i).getBCol() * widthCell,
                            yLeftUpper + game.maze.boxes.get(i).getBRow() * heightCell,
                            widthCell, heightCell);
                } else{
                    drawImage(g, images.ground,
                            xLeftUpper + game.maze.boxes.get(i).getBCol() * widthCell,
                            yLeftUpper + game.maze.boxes.get(i).getBRow() * heightCell,
                            widthCell, heightCell );
                    drawImage(g, images.bBox,
                            xLeftUpper + game.maze.boxes.get(i).getBCol() * widthCell,
                            yLeftUpper + game.maze.boxes.get(i).getBRow() * heightCell,
                            widthCell, heightCell);
                }
            }
                drawImage(g, images.getDirection(),
                        xLeftUpper + game.maze.getRobotCol() * widthCell,
                        yLeftUpper + game.maze.getRobotRow() * heightCell,
                        widthCell, heightCell);
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
                images.direction("up");
                game.maze.move(-1,0);

            } else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                images.direction("down");
                game.maze.move(1,0);

            } else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                images.direction("left");
                game.maze.move(0,-1);

            } else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                images.direction("right");
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
