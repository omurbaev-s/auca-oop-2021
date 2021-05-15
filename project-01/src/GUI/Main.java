package GUI;

import processing.core.*;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Buttons> buttons = new ArrayList<>();
    Window window;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        window = new Window(this, width/2.5f,height/3f,width/5f,height/3f);

        buttons.add(new Buttons(this, window.getX(),window.getY(),window.getWidth(),window.getHeight(), () ->{

        }));
    }

    public void draw() {
        background(0, 0, 0);
        for(Buttons button : buttons) {
            button.draw(window.getX(),window.getY(),window.getWidth(),window.getHeight());
        }
    }
    public void mouseReleased(){
        for(Buttons button : buttons){
            if(button.contains(mouseX,mouseY)){
                button.performAction();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("GUI.Main");
    }

}