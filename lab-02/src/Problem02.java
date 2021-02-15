import processing.core.*;

public class Problem02 extends PApplet {
    Star[] stars = new Star[100];

    public void settings() {
        fullScreen();
    }

    public void setup() {
        noStroke();
        for(int i = 0; i< stars.length; i++) {
            stars[i] = new Star(this, random(width), random(height), random(10, 30), random(-10, 10), random(-10, 10));
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