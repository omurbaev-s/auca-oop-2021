package GUI;

public class Window {
    private Main main;
    private int x;
    private int y;
    private float width;
    private float height;

    public Window(Main main, int x, int y, float width, float height){
        this.main=main;
        this.x=x;
        this.y=y;
        this.width=Math.round(width/9f);
        this.height=Math.round(height/9f);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public float h() {
        return this.y+(height*9);
    }

    public float w() {
        return this.x+(width*9);
    }
}
