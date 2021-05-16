package GUI;

import processing.core.*;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Buttons> buttons = new ArrayList<>();
    ArrayList<openedButton> opened = new ArrayList<>();
    Window window;
    Game game=null;
    openedButton button;

    public void settings() {
        fullScreen();
    }
// Try to create a new frame where all buttons are in this frame (9x9)
    public void setup() {
        game = new Game(9,9,10);
        window = new Window(this, width/2,height/3,width/5f,height/3f);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int finalI = i;
                int finalJ = j;
                buttons.add(new Buttons(this, window.getWidth()*j+window.getX(), window.getHeight()*i+window.getY(), window.getWidth(), window.getHeight(), () ->{
                    if(mouseButton==LEFT) {
                        game.left(finalI, finalJ);
                        game.floodFill(finalI, finalJ);
                        opened.add(new openedButton(this, window.getWidth() * finalJ + window.getX(), window.getHeight() * finalI + window.getY(), window.getWidth(), window.getHeight(), String.valueOf(game.data[finalI][finalJ])));
                    }
                }));



            }
        }
        buttons.add(new CommandButton(this, window.getWidth()+window.w(), window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(), "beginner",() ->{

        }));
        buttons.add(new CommandButton(this, window.getWidth()+window.w(), 4*window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(),"intermediate",() ->{

        }));
        buttons.add(new CommandButton(this, window.getWidth()+window.w(), 7*window.getHeight()+window.getY(), width/7f,1.5f*window.getHeight(),"expert",() ->{

        }));
        buttons.add(new Buttons(this, (width/2f)-window.getWidth(), window.getY()-window.getHeight()*2.5f, 2*window.getWidth(),2*window.getHeight(),() ->{

        }));


    }

    public void draw() {
        background(0);
        for(Buttons button : buttons) {
            button.draw();
        }
        for(openedButton button : opened){
            button.draw();
        }
    }
    public void mouseReleased(){
        for(Buttons button : buttons){
            if(button.contains(mouseX,mouseY)){
                button.performAction();
            }
        }


    }
//    public void mousePres(){
//        background(255);
//    }

    public static void main(String[] args) {
        PApplet.main("GUI.Main");
    }

}