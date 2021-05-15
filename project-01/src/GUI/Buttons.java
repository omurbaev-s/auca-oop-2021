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

    public void draw() {
        float dw = this.width / 10f;
        float dh = this.height / 10f;
                float x1 = this.x + dw;
                float y1 = this.y + dh;
                if (isPressed || main.mousePressed && contains(main.mouseX, main.mouseY)) {
                    main.fill(DARK_GRAY);
                    main.stroke(DARK_GRAY);
                    main.rect(x, y, this.width, this.height);
                    main.fill(PRESS_GRAY);
                    main.stroke(PRESS_GRAY);
                    main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);
                } else {
                    main.fill(DARK_GRAY);
                    main.stroke(DARK_GRAY);
                    main.rect(x, y, this.width, this.height);
                    main.fill(LIGHT_GRAY);
                    main.stroke(LIGHT_GRAY);
                    main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);
                }
    }
    public boolean contains(int mouseX, int mouseY) {
        return mouseX>=this.x && mouseX<=this.x+width && mouseY>=this.y && mouseY<=this.y+height;
    }

//    public void performAction() {
//        action.perform();
//    }
}
