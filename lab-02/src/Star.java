import processing.core.PApplet;

public class Star {
    private Problem02 main;
    private float x;
    private float y;
    private float r;
    private float dx;
    private float dy;
    private float rc;
    private float gc;
    private float bc;

    public Star(Problem02 main, float x, float y, float r, float dx, float dy) {
        this.main = main;
        this.x = x;
        this.y = y;
        this.r = r;
        this.dx = dx;
        this.dy = dy;
        rc = main.random(255);
        gc = main.random(255);
        bc = main.random(255);
    }

    public void draw() {
        main.fill(rc, gc, bc);
        main.circle(x, y, r);
    }

    public void move() {
        x+=dx;
        if(x>=main.width || x<=0){
            dx = -dx;
        }
        y+=dy;
        if(y>=main.height || y<=0){
            dy = -dy;
        }
    }
}
