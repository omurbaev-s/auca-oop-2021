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

        for(float i=window.getY(); i<window.h(); i+=window.getHeight()){
            for(float j=window.getX(); j<window.w(); j+=window.getWidth()){
                buttons.add(new Buttons(this, j, i, window.getWidth(), window.getHeight(), () ->{

                }));
            }
        }
        buttons.add(new Buttons(this, window.getWidth()+window.w(), window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(),() ->{

        }));
        buttons.add(new Buttons(this, window.getWidth()+window.w(), 4*window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(),() ->{

        }));
        buttons.add(new Buttons(this, window.getWidth()+window.w(), 7*window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(),() ->{

        }));
        buttons.add(new Buttons(this, width/2f, window.getY()-window.getHeight()*2.5f, 2*window.getWidth(),2*window.getHeight(),() ->{

        }));


    }

    public void draw() {
        background(0);
        for(Buttons button : buttons) {
            button.draw();
        }
    }
//    public void mouseReleased(){
//        for(Buttons button : buttons){
//            if(button.contains(mouseX,mouseY)){
//                button.performAction();
//            }
//        }
//    }

    public static void main(String[] args) {
        PApplet.main("GUI.Main");
    }

}