package practice13;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Flag> flags = new ArrayList<>();

        flags.add(new Flag(1,1));
        flags.add(new Flag(7,7));
        flags.add(new Flag(3,5));

        while(true){
            System.out.println(flags);

            int row = inp.nextInt();
            int col = inp.nextInt();

            if(row == -1 || col == -1){
                break;
            }
            Flag flag = new Flag(row, col);

            if(flags.contains(flag)){
                flags.remove(flag);
            } else{
                flags.add(flag);
            }
        }

    }
}
