package console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        Game game = null;

        try {
            game = parseArgs(args);
            System.out.println(getHelp());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect integer values in command line arguments: " + Arrays.toString(args));
            System.exit(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(getUsage());
            System.exit(1);
        }


        for (; ; ) {
            System.out.println(game);
            if(game.win){
                System.out.println("\nCongratulations!");
                break;
            }
            if(game.isBomb()){
                System.out.println("\nNext time you will be better");
                break;
            }
            System.out.print("cmd: ");
            try {
                String cmdLine = inp.nextLine().trim();
                if (cmdLine.equals("quit")) {
                    if (game.firstClick) {
                        System.out.println("\nThe field will be mined after first left click");
                        System.out.println("Next time you will be better");
                    } else {
                        System.out.println("\nNext time you will be better");
                    }
                    break;
                }

                Scanner cmdInp = new Scanner(cmdLine);
                String firstArg = cmdInp.next();
                switch (firstArg) {
                    case "help":
                        System.out.println(getHelp());
                        break;
                    case "left":
                        try {
                            int row = cmdInp.nextInt();
                            int col = cmdInp.nextInt();
                            game.left(row, col);
                            game.floodFill(row, col);
                            System.out.println();
                            break;
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    case "right":
                        try {
                            int row = cmdInp.nextInt();
                            int col = cmdInp.nextInt();
                            if (!game.firstClick) {
                                game.right(row, col);
                                System.out.println();
                                break;
                            } else {
                                System.out.println("The field will be mined after first left click\n");
                            }
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "show":
                        if (game.firstClick) {
                            System.out.println("The field will be mined after first left click\n");
                        } else {
                            game.show();
                            System.out.println();
                        }
                        break;
                }
            } catch (NoSuchElementException e){
                if(game.firstClick) {
                    System.out.println("The field will be mined after first left click\n");
                }
                System.out.println("Next time you will be better");
                break;
            }
        }
        System.out.println("Bye");
    }


    static Game parseArgs(String[] args){
        int width = 9;
        int height = 9;
        int mines = 10;


        if(args.length==0 || args.length==1 && args[0].contains("beginner")){
            return new Game(height, width, mines);
        }else if(args.length==1){
            if(args[0].equals("intermediate")){
                width=16;
                height=16;
                mines=40;
                return new Game(height,width,mines);
            } else if(args[0].equals("expert")){
                width=30;
                height=16;
                mines=99;
                return new Game(height,width,mines);
            } else{
                System.out.println("Unknown mode: "+Arrays.toString(args).replace('[',' ').replace(']',' ').trim());
                System.out.println(getUsage());
                System.exit(1);
            }
        }else if (args.length == 3) {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
                mines = Integer.parseInt(args[2]);
                return new Game(height,width,mines);
            }

            throw new RuntimeException("Incorrect app args: "+Arrays.toString(args).replace('[',' ').replace(']',' ').trim());


    }

    private static StringBuilder getUsage() {
        StringBuilder usage = new StringBuilder();
        usage.append("Usage:\n");
        usage.append("java -jar Minesweeper.jar beginner\n");
        usage.append("    - game in the beginner mode: height=16, width=9, mines=10\n");
        usage.append("java -jar Minesweeper.jar intermediate\n");
        usage.append("    - game in the beginner mode: height=16, width=16, mines=40\n");
        usage.append("java -jar Minesweeper.jar expert\n");
        usage.append("    - game in the beginner mode: height=16, width=30, mines=99\n");
        usage.append("java -jar Minesweeper.jar \n");
        usage.append("    - equivalent to"+" java -jar Minesweeper.jar beginner"+"\n");
        usage.append("java -jar Minesweeper.jar <height> <width> <mines>\n");
        usage.append("    - game with the specified height, width, and number of mines\n");
        return usage;
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
        help.append("    - quit the game (EOF works too)\n");
        help.append("help\n");
        help.append("    - this text\n");
        return help;
    }
}
