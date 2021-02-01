public class Problem01 {
    static final int CANVAS_SIZE = 20;
    static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];
    public static void main(String[] args) {
        for(int row=0; row<CANVAS_SIZE; row++){
            for(int col=0; col<CANVAS_SIZE; col++){
                canvas[row][col]='.';
            }
        }
        showCanvas();
    }

    static void showCanvas() {
        for(int row=0; row<CANVAS_SIZE; row++){
            for(int col=0; col<CANVAS_SIZE; col++){
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
    }
    static void moveTurtle(){

    }
}
