public class Turtle {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private Canvas canvas;
    private int row;
    private int col;
    private boolean isPenDown;
    private int dir;

    public Turtle(Canvas aCanvas, int aRow, int aCol, boolean penDown, int aDir) {
        canvas = aCanvas;
        row = aRow;
        col = aCol;
        isPenDown = penDown;
        dir = aDir;
    }

    public void turnRight() {
        dir=(dir+1)%4;

    }
    public void turnLeft() {
        dir--;
        if(dir==-1){
            dir=3;
        }
    }

    public void penUp() {
        isPenDown=false;
    }

    public void penDown() {
        isPenDown=true;
        canvas.set(row,col);
    }
    public void move(int nSteps){
        for(int i=0; i<nSteps; i++){

            switch (dir) {
                case NORTH:
                   row--;
                    break;
                case EAST:
                    col++;
                    break;
                case SOUTH:
                    row++;
                    break;
                case WEST:
                    col--;
                    break;
            }
            if(!canvas.isOnCanvas(row, col)){
                throw new RuntimeException("Turtle is out of Canvas: "+row+", "+ col);
            }
            if(isPenDown){
                canvas.set(row, col);
            }
        }
    }
}
