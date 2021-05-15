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

    public Buttons(Main main, int x, int y, int width, int height) {
        this.main = main;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isPressed = false;
    }

    public void draw(float x, float y, float width, float height) {
        this.width = Math.round(width / 9f);
        this.height = Math.round(height / 9f);
        float dw = this.width / 10f;
        float dh = this.height / 10f;

        for (float i = y; i < y + (this.height * 9); i += this.height) {
            for (float j = x; j < x + (this.width * 9); j += this.width) {
                float x1 = j + dw;
                float y1 = i + dh;
                if (isPressed || main.mousePressed && contains(main.mouseX, main.mouseY, i, j, this.width, this.height)) {
                    main.fill(DARK_GRAY);
                    main.stroke(DARK_GRAY);
                    main.rect(j, i, this.width, this.height);
                    main.fill(PRESS_GRAY);
                    main.stroke(PRESS_GRAY);
                    main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);
                } else {
                    main.fill(DARK_GRAY);
                    main.stroke(DARK_GRAY);
                    main.rect(j, i, this.width, this.height);
                    main.fill(LIGHT_GRAY);
                    main.stroke(LIGHT_GRAY);
                    main.rect(x1, y1, this.width - 2 * dw, this.height - 2 * dh);
                }

            }
        }
    }
    private boolean contains(int mouseX, int mouseY, float i, float j, float width, float height) {
        return mouseX>=j && mouseX<=j+width && mouseY>=i && mouseY<=i+height;
    }
}
