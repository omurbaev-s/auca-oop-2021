package prototype05;

import java.awt.*;

public class Circle extends Figure{
    private int r;

    public Circle(int x, int y, int r){
        super(x,y);
        if(r<0){
            throw new IllegalArgumentException("Circle: radius<0");
        }

        this.r=r;

    }
    @Override
    public String toString() {
        return String.format("Circle (%d, %d, %d)", x,y,r);
    }

    public boolean contains(int xClick, int yClick) {
        int dx = xClick-x;
        int dy = yClick-y;
        return r * r >= dx * dx + dy * dy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x-r, y-r,2*r,2*r);
    }
}
