package Buttons;

import processing.core.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<MyButton> buttons = new ArrayList<>();
    float backgroundColor=0;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        buttons.add(new commandButton(this,100,100,200,100, "Exit", () -> System.exit(0)));
        buttons.add(new MyButton(this,700,100,200,100, () -> backgroundColor= random(255)));
        buttons.add(new MyButton(this,500,500,200,300, () -> JOptionPane.showMessageDialog(null,"hello")));
    }

    public void draw() {
        background(backgroundColor);
        for(MyButton button: buttons){
            button.draw();
        }
    }

    public void mouseReleased(){
        for(MyButton button: buttons){
            if(button.contains(mouseX, mouseY)){
                button.performAction();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Buttons.Main");
    }

}