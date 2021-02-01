import java.util.Scanner;

public class Problem01 {
    static final int CANVAS_SIZE = 20;

    static Scanner inp = new Scanner(System.in);

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;
    static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];
    static int turtleRow = 0;
    static int turtleCol = 0;
    static boolean turtleIsPenDown = false;
    static int turtleDir = EAST;

    static String userCmd;
    static int numberOfSteps;

    public static void main(String[] args) {
       try {
           run();
       } catch (RuntimeException e){
           System.out.println("Your program has a problem: ");
           System.out.println("\t"+e.getMessage());
       }
    }

    private static void run() {
        init();

        readUserCommand();
        while(!userCmd.equals("Exit")){
            switch (userCmd){
                case "PenUp":
                    penUp();
                    break;
                case "PenDown":
                    penDown();
                    break;
                case "Move":
                    move(numberOfSteps);
                    break;
                case "Print":
                    showCanvas();
                    break;
                case "TurnLeft":
                    turnLeft();
                    break;
                case "TurnRight":
                    turnRight();
                    break;
            }
            readUserCommand();
        }
        
    }

    private static void readUserCommand() {
        String line = inp.nextLine();
        switch (line){
            case "PenUp":
            case "PenDown":
            case "Print":
            case "TurnLeft":
            case "TurnRight":
                userCmd=line;
                numberOfSteps=0;
                return;
        }
        Scanner inpLine = new Scanner(line);
        userCmd = inpLine.next();
        numberOfSteps = inpLine.nextInt();
    }

    private static void turnLeft() {
        turtleDir--;
        if(turtleDir==-1){
            turtleDir=3;
        }
    }

    private static void turnRight() {
        turtleDir=(turtleDir+1)%4;

    }

    private static void penUp() {
        turtleIsPenDown=false;
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
            if(!isInCanvas(turtleRow, turtleCol)){
                throw new RuntimeException("Turtle is out of Canvas: "+turtleRow+", "+ turtleCol);
            }
            if(turtleIsPenDown){
                canvas[turtleRow][turtleCol]='*';
            }
            switch (turtleDir) {
                case NORTH:
                    turtleRow--;
                    break;
                case EAST:
                turtleCol++;
                break;
                case SOUTH:
                    turtleRow++;
                    break;
                case WEST:
                    turtleCol--;
                    break;
            }
        }
    }

    static boolean isInCanvas(int turtleRow, int turtleCol) {
        return 0<=turtleRow && turtleRow<CANVAS_SIZE && 0<=turtleCol && turtleCol<CANVAS_SIZE;
    }
}
