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
            System.out.println(getHelp());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect integer values in command line arguments: " + Arrays.toString(args));
            System.exit(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }


        for (; ; ) {
            System.out.println(game);
            if(game.win){
                System.out.println("Congratulations!");
                break;
            }
            if(game.isBomb()){
                System.out.println("Next time you will be better");
                break;
            }
            System.out.print("cmd: ");
            String cmdLine = inp.nextLine().trim();
            if(cmdLine.equals("quit")){
                if(game.firstClick){
                    System.out.println("\nThe field will be mined after first left click");
                    System.out.println("Next time you will be better");
                }else {
                    System.out.println("\nNext time you will be better");
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
                        System.out.println();
                        break;
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case "right":
                    try{
                        int row = cmdInp.nextInt();
                        int col = cmdInp.nextInt();
                        if(!game.firstClick) {
                            Flag flag = new Flag(row, col);

                            if (flags.contains(flag)) {
                                flags.remove(flag);
                            } else {
                                flags.add(flag);
                            }
                            game.right(row, col, flags);
                            System.out.println();
                            break;
                        }else{
                            System.out.println("The field will be mined after first left click\n");
                        }
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case "help":
                    System.out.println(getHelp());
                    break;
            }
        }
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

            throw new RuntimeException("Incorrect app args: "+Arrays.toString(args).replace('[',' ').replace(']',' ').trim());

    }

    private static StringBuilder getHelp() {
        StringBuilder help = new StringBuilder();
        help.append("Help:\n");
        help.append("left <row> <col>\n");
        help.append("    - left click with coordinates (row, col)\n");
        help.append("right <row> <col>\n");
        help.append("    - right click with coordinates (row, col)\n");
        help.append("show\n");
        help.append("    - show all mines (cheating\n");
        help.append("quit\n");
        help.append("    - quit the game (EOF works too\n");
        help.append("help\n");
        help.append("    - this text\n");
        return help;
    }
}
