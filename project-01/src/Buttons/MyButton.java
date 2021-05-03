package Buttons;

public class MyButton {
    private static final float DARK_GRAY=50;
    private static final float PRESS_GRAY=100;
    private static final float LIGHT_GRAY=200;
    protected Main main;
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    private boolean isPressed;
    private Actionable action;

    public MyButton(Main main, int x, int y, int w, int h, Actionable action) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.action=action;
        this.main=main;
        this.isPressed=false;
        if(w<0 || h<0){
            throw new RuntimeException("Incorrect coordinates");
        }
    }

    public void draw() {
        float dw = w/20f;
        float dh = h/20f;
        float x2 = x+dw;
        float y2 = y+dh;
        if(isPressed || main.mousePressed && contains(main.mouseX, main.mouseY)){
            main.fill(DARK_GRAY);
            main.rect(x,y,w,h);
            main.fill(PRESS_GRAY);
            main.rect(x2,y2,w-2*dw,h-2*dh);
        } else{
            main.fill(DARK_GRAY);
            main.rect(x,y,w,h);
            main.fill(LIGHT_GRAY);
            main.rect(x2,y2,w-2*dw,h-2*dh);
        }
    }

    public boolean contains(int mouseX, int mouseY) {
        return x<=mouseX && mouseX<x+w && y<=mouseY && mouseY<y+h;
    }

    public void performAction() {
        action.perform();
    }
}
