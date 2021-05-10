package prototype05;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {
    ArrayList<Figure> figures = new ArrayList<>();
    Figure selectedFigure=null;
    int prevMouseX=-1;
    int prevMouseY=-1;

    JPanel controlPanel;
    CanvasPanel mainPanel;
    JButton rectButton = new JButton("Rect");
    JButton circleButton = new JButton("Circle");
    JButton crossButton = new JButton("Cross");

    Main(){
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 3));
        controlPanel.add(rectButton);
        controlPanel.add(circleButton);
        controlPanel.add(crossButton);
        add(controlPanel, BorderLayout.SOUTH);

        rectButton.addActionListener(e -> {
           figures.add(new Rect(0,0, 100,100));
           repaint();
            mainPanel.requestFocus();
        });
        circleButton.addActionListener(e -> {
            figures.add(new Circle(150,50, 50));
            repaint();
            mainPanel.requestFocus();
        });
        crossButton.addActionListener(e -> {
            figures.add(new Cross(250,50, 100,10));
            repaint();
            mainPanel.requestFocus();
        });

        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_DELETE && selectedFigure!=null){
                    figures.remove(selectedFigure);
                    selectedFigure=null;
                    repaint();
                }
            }
        });
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON3){
                    if(selectedFigure != null){
                        selectedFigure.setSelected(false);
                        selectedFigure=null;
                    }
                    for (Figure f : figures) {
                        if (f.contains(e.getX(), e.getY())) {
                            selectedFigure=f;
                        }
                    }
                    if(selectedFigure != null){
                        selectedFigure.setSelected(true);
                        repaint();
                        JOptionPane.showMessageDialog(Main.this, selectedFigure.toString());
                    }
            }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton()==MouseEvent.BUTTON1){
                    if(selectedFigure != null){
                        selectedFigure.setSelected(false);
                        selectedFigure=null;
                    }
                    for(Figure f : figures){
                        if(f.contains(e.getX(),e.getY())){
                            f.setSelected(true);
                            selectedFigure=f;
                            prevMouseX=e.getX();
                            prevMouseY=e.getY();
                            repaint();
                        }
                    }
                }
            }
        });
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(SwingUtilities.isLeftMouseButton(e)) {
                    if (selectedFigure != null) {
                        int dx = e.getX() - prevMouseX;
                        int dy = e.getY() - prevMouseY;
                        prevMouseX = e.getX();
                        prevMouseY = e.getY();
                        selectedFigure.move(dx, dy);
                        repaint();
                    }
                }
            }
        });

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
            super.paintComponent(g);
            for(Figure f: figures){
                f.draw(g);
            }
        }
    }
}
