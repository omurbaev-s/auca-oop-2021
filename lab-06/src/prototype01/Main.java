package prototype01;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Rect> rects = new ArrayList<>();

        rects.add(new Rect(100, 100, 100, 100));
        rects.add(new Rect(600, 100, 50, 100));
        rects.add(new Rect(300, 300, 25, 50));

        while(true){
            int xClick = inp.nextInt();
            int yClick = inp.nextInt();

            if(xClick==-1 && yClick==-1){
                break;
            }
            for(Rect r: rects){
                if(r.contains(xClick,yClick)){
                    System.out.println(r);
                }
            }
        }

    }
}
