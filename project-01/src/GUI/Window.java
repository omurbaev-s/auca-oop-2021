package GUI;

public class Window {
    private Main main;
    private float x;
    private float y;
    private float width;
    private float height;

    public Window(Main main, float x, float y, float width, float height){
        this.main=main;
        this.x=x;
        this.y=y;
        this.width=Math.round(width/9f);
        this.height=Math.round(height/9f);
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public void draw() {
        main.fill(50);
        main.rect(x,y,width,height);

    }

    public float h() {
        return this.y+(height*9);
    }

    public float w() {
        return this.x+(width*9);
    }
}
