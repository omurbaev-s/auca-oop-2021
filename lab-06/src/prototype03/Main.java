package prototype03;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Figure>figures =  Utils.createFigures();


        while(true){
            int xClick = inp.nextInt();
            int yClick = inp.nextInt();

            if(xClick==-1 && yClick==-1){
                break;
            }
            for(Figure f: figures){
                if(f.contains(xClick,yClick)){
                    System.out.println(f);
                }
            }
        }

    }
}
