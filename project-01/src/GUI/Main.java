package GUI;

import processing.core.*;

public class Main extends PApplet {

    Buttons button;
    Window window;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        button = new Buttons(this, 100,100,50,50);
        window = new Window(this, width/2.5f,height/3f,width/5f,height/3f);
    }

    public void draw() {
        background(0, 0, 0);
        button.draw(window.getX(), window.getY(), window.getWidth(), window.getHeight());
    }

    public static void main(String[] args) {
        PApplet.main("GUI.Main");
    }

}