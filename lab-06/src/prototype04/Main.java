package prototype04;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Figure> figures =  Utils.createFigures();


        while(true){
            System.out.print("cmd: ");
            String line = inp.nextLine();
            if(line.equals("stop")){
                break;
            } else if(line.equals("show all")){
                System.out.println(figures);
            } else if(line.equals("click")){
                System.out.print("x: ");
                int x = inp.nextInt();
                System.out.print("y: ");
                int y = inp.nextInt();
                inp.nextLine();
                for(Figure f: figures){
                    if(f.contains(x,y)){
                        System.out.println(f);
                    }
                }
            } else if(line.equals("move")){
                System.out.print("x1: ");
                int x1 = inp.nextInt();
                System.out.print("y1: ");
                int y1 = inp.nextInt();
                System.out.print("x2: ");
                int x2 = inp.nextInt();
                System.out.print("y2: ");
                int y2 = inp.nextInt();
                inp.nextLine();
                for(Figure f : figures){
                    if(f.contains(x1,y1)){
                        f.move(x2-x1, y2-y1);
                    }
                }
            }

        }

    }
}
