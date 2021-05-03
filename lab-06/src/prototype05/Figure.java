package prototype05;

import java.awt.*;

public abstract class Figure {
    protected int x;
    protected int y;
    public Figure(int x, int y){
        this.x=x;
        this.y=y;
    }

    public abstract boolean contains (int xClick, int yClick);

    public void move(int dx, int dy) {
        x+=dx;
        y+=dy;
    }

    public abstract void draw(Graphics g);
}
