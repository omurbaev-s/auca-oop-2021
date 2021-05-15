package GUI;

public class Buttons {
    private static final float DARK_GRAY = 150;
    private static final float PRESS_GRAY = 100;
    private static final float LIGHT_GRAY = 200;
    private Main main;
    private float x;
    private float y;
    private float width;
    private float height;
    private boolean isPressed;
   // private Actionable action;


    public Buttons(Main main, float x, float y, float width, float height/*, Actionable action*/) {
        this.main = main;
       // this.action=action;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isPressed = false;

    }

    public void draw(/*float x, float y, float width, float height*/) {
//        this.width = Math.round(width / 9f);
//        this.height = Math.round(height / 9f);
//        float dw = this.width / 10f;
//        float dh = this.height / 10f;
//        for (float i = y; i < y + (this.height * 9); i += this.height) {
//            for (float j = x; j < x + (this.width * 9); j += this.width) {
//                this.x = j + dw;
//                this.y = i + dh;
//                if (isPressed || main.mousePressed && contains(main.mouseX, main.mouseY)) {
                    main.fill(DARK_GRAY);
//                    main.stroke(DARK_GRAY);
                    main.rect(x, y, this.width, this.height);
//                    main.fill(PRESS_GRAY);
//                    main.stroke(PRESS_GRAY);
//                    main.rect(this.x, this.y, this.width - 2 * dw, this.height - 2 * dh);
//                } else {
//                    main.fill(DARK_GRAY);
//                    main.stroke(DARK_GRAY);
//                    main.rect(x, y, this.width, this.height);
//                    main.fill(LIGHT_GRAY);
//                    main.stroke(LIGHT_GRAY);
//                    main.rect(this.x, this.y, this.width - 2 * dw, this.height - 2 * dh);
//                }

//            }
//        }
    }
    public boolean contains(int mouseX, int mouseY) {
        return mouseX>=this.x && mouseX<=this.x+width && mouseY>=this.y && mouseY<=this.y+height;
    }

//    public void performAction() {
//        action.perform();
//    }
}
