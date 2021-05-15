package GUI;

public class Buttons {
    private Main main;
    private float x;
    private float y;
    private float width;
    private float height;
    private boolean isPressed;

    public Buttons(Main main, int x, int y, int width, int height){
        this.main=main;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.isPressed=false;
    }

    public void draw(float x, float y,float width, float height) {
        this.width = Math.round(width/9f);
        this.height = Math.round(height/9f);
        float dw = this.width/10f;
        float dh = this.height/10f;
        if(!isPressed){
            for(float i=y; i<y+(this.height*9); i+=this.height){
                for(float j=x;j<x+(this.width*9); j+=this.width){
                    float x1 = j+dw;
                    float y1 = i+dh;
                    main.fill(150);

                    main.rect(j, i, this.width,this.height);
                    main.fill(200);
                    main.stroke(200);
                    main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);
                }
            }
        }

    }
}
