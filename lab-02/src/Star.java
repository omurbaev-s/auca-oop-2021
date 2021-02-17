import processing.core.PConstants;

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
    private float angle;
    private float dAngle;


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
        angle = 0;
        dAngle = main.random(0.05f,0.2f);
    }

    public void draw() {
        main.stroke(rc, gc, bc);
        main.pushMatrix();
        main.translate(x,y);
        main.rotate(angle);
        for(int i=0; i<4; i++) {
            angle+=dAngle;
            main.line(0, -r, 0, r);
            main.rotate(2*PConstants.PI/8);
        }
        main.popMatrix();
    }

    public void move() {
        x+=dx;
        if(x+r>=main.width || x-r<=0){
            dx = -dx;
            dAngle = -dAngle;
        }
        y+=dy;
        if(y+r>=main.height || y-r<=0){
            dy = -dy;
            dAngle = -dAngle;
        }
    }
}
