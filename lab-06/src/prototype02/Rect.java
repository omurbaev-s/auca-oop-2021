package prototype02;

public class Rect {
    private int x;
    private int y;
    private int w;
    private int h;

    public Rect(int x, int y, int w, int h){
        if(w<0){
            throw new IllegalArgumentException("Rect: width <0 ");
        }
        if(h<0){
            throw new IllegalArgumentException("Rect: height<0 ");
        }

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean contains(int aX, int aY) {
        return x<=aX && aX<=x+w && y<=aY && aY<=y+h;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d, %d, %d, %d)",x,y,w,h);
    }
}
