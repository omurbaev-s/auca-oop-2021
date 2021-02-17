import processing.core.*;

public class Problem02 extends PApplet {
    Star[] stars = new Star[100];
    final int MIN_R=5;
    final int MAX_R=25;
    float r;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        noStroke();
        for(int i = 0; i< stars.length; i++) {
            r = random(MIN_R, MAX_R);
            stars[i] = new Star(this, random(0+r,width-r), random(0+r,height-r), r, random(-5, 5), random(-5, 5));
        }
        frameRate(60);
    }

    public void draw() {
        background(0, 0, 50);
        for(int i = 0; i< stars.length; i++) {
            stars[i].draw();
            stars[i].move();
        }
    }

    public static void main(String[] args) {
        PApplet.main("Problem02");
    }

}