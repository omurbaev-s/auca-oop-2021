package GUI;

import processing.core.PConstants;

public class CommandButton extends Buttons {
    private String text;

    public CommandButton(Main main, float x, float y, float width, float height, String text, Actionable action){
        super(main,x,y,width,height,action);
        this.text=text;
    }

    @Override
    public void draw() {
        super.draw();
        float xCenter = x + width/2f;
        float yCenter = y + height/1.5f;
        main.fill(0,200,0);
        main.textSize(20);
        main.textAlign(PConstants.CENTER);
        main.text(text, xCenter, yCenter);
    }
}
