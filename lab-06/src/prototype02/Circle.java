package prototype02;

public class Circle {
    private int x;
    private int y;
    private int r;

    public Circle(int x, int y, int r){
        if(r<0){
            throw new IllegalArgumentException("Circle: radius<0");
        }
        this.x=x;
        this.y=y;
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
}
