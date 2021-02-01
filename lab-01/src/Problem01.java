public class Problem01 {
    static final int CANVAS_SIZE = 20;
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;
    static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];
    static int turtleRow = 0;
    static int turtleCol = 0;
    static boolean turtleIsPenDown = false;
    static int turtleDir = EAST;
    public static void main(String[] args) {
        init();
        penDown();
        move(10);
        showCanvas();
    }

    static void penDown() {
        turtleIsPenDown=true;
    }

    static void init() {
        for(int row=0; row<CANVAS_SIZE; row++){
            for(int col=0; col<CANVAS_SIZE; col++){
                canvas[row][col]='.';
            }
        }
    }

    static void showCanvas() {
        for(int row=0; row<CANVAS_SIZE; row++){
            for(int col=0; col<CANVAS_SIZE; col++){
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
    }
    static void move(int nSteps){
        for(int i=0; i<nSteps; i++){
            if(turtleIsPenDown){
                canvas[turtleRow][turtleCol]='*';
            }
            turtleCol++;
        }
    }
}
