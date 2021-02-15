import java.util.Scanner;

public class Problem01 {
    static int nLine=0;
    public static void main(String[] args) {
        try {
            run();
        } catch (RuntimeException e){
            System.out.println("Your program has a problem in line "+nLine+":");
            System.out.println("\t"+e.getMessage());
        }

        UserCommand cmd;

    }

    private static void run() {
        Scanner inp = new Scanner(System.in);
        Canvas canvas = new Canvas();
        Turtle turtle = new Turtle(canvas, 0, 0, false, Turtle.EAST);

       nLine++;
        UserCommand cmd = new UserCommand(inp.nextLine());
        while(!cmd.getCommand().equals(UserCommand.EXIT)){
            nLine++;
            switch (cmd.getCommand()){
                case UserCommand.PEN_UP:
                    turtle.penUp();
                    break;
                case UserCommand.PEN_DOWN:
                    turtle.penDown();
                    break;
                case UserCommand.MOVE:
                    turtle.move(cmd.getNumOfSteps());
                    break;
                case UserCommand.PRINT:
                    canvas.show();
                    break;
                case UserCommand.TURN_LEFT:
                    turtle.turnLeft();
                    break;
                case UserCommand.TURN_RIGHT:
                    turtle.turnRight();
                    break;
            }
            nLine++;
            cmd = new UserCommand(inp.nextLine());
        }
    }
}
