package prototype05;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {
    ArrayList<Figure> figures = new ArrayList<>();

    JPanel controlPanel;
    CanvasPanel mainPanel;
    JButton rectButton = new JButton("Rect");
    JButton circleButton = new JButton("Circle");
    JButton crossButton = new JButton("Cross");

    Main(){
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
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
        });
        circleButton.addActionListener(e -> {
            figures.add(new Circle(150,50, 50));
            repaint();
        });
        crossButton.addActionListener(e -> {
            figures.add(new Cross(250,50, 100,10));
            repaint();
        });

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(Figure f: figures){
                    if(f.contains(e.getX(), e.getY())){
                        JOptionPane.showMessageDialog(Main.this, f.toString());
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
