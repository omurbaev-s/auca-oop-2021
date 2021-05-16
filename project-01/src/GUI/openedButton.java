package GUI;

import processing.core.PConstants;

public class openedButton {
    private Main main;
    private String text;
    private float x;
    private float y;
    private float width;
    private float height;

    public openedButton(Main main, float x, float y, float width, float height, String text) {
        this.main=main;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.text=text;
    }


    public void draw() {
        float dw = this.width / 10f;
        float dh = this.height / 10f;
        float x1 = this.x + dw;
        float y1 = this.y + dh;
       // if(main.mouseX>=x1 && main.mouseX<=x1+(width-2*dw) && main.mouseY>=y1 && main.mouseY<=y1+(height-2*dw)){
            main.fill(100);
            main.stroke(100);
            main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);


            float xCenter = x + width / 2f;
            float yCenter = y + height / 1.5f;
            main.fill(0, 200, 0);
            main.textSize(15);
            main.textAlign(PConstants.CENTER);
            main.text(text, xCenter, yCenter);
        //}
    }

    public boolean contains(int mouseX, int mouseY) {
        return mouseX>=x+(width/10f) && mouseX<=(x+(width/10f))+(width-2*(width/10f)) && mouseY>=y+(height/10f) && mouseY<=(y+(height/10f))+(height-2*(height/10f));
    }
}
