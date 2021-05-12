package console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        Game game = null;
        ArrayList<Flag> flags = new ArrayList<>();

        try {
            game = parseArgs(args);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect integer values in command line arguments: " + Arrays.toString(args));
            System.exit(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }


        for (; ; ) {
            System.out.println(game);
            System.out.println(game.opened);
            System.out.print("cmd: ");
            if(game.isBomb()){
                break;
            }
            String cmdLine = inp.nextLine().trim();
            if(cmdLine.equals("quit")){
                if(game.firstClick){
                    System.out.println("\nThe field will be mined after first left click");
                }
                break;
            }

            ArrayList<String> cmdArgs = new ArrayList<>();
            Scanner cmdInp = new Scanner(cmdLine);
            String firstArg= cmdInp.next();
            switch (firstArg){
                case "left":
                    try {
                        int row = cmdInp.nextInt();
                        int col = cmdInp.nextInt();
                        game.left(row, col);
                        game.floodFill(row, col);
                        break;
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                case "right":
                    try{
                        int row = cmdInp.nextInt();
                        int col = cmdInp.nextInt();
                        Flag flag = new Flag(row, col);

                        if(flags.contains(flag)){
                            flags.remove(flag);
                        } else{
                            flags.add(flag);
                        }
                        game.right(row, col, flags);
                        break;

                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
            }
        }
        System.out.println("Next time you will be better");
        System.out.println("Bye");
    }

    static Game parseArgs(String[] args){
        int width = 9;
        int height = 9;
        int mines = 10;

        if(args.length==0){
            return new Game(height, width, mines);
        }
            if (args.length == 3) {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
                mines = Integer.parseInt(args[2]);
                return new Game(height,width,mines);
            }
            throw new RuntimeException("Incorrect number of command line arguments");

    }
}
