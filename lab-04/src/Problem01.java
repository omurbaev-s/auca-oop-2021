import java.util.ArrayList;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(inp.hasNextInt()){
            int x = inp.nextInt();
            list.add(x);
        }
        System.out.println(list);

        int lft=0;
        int rgt= list.size()-1;
        while (lft<rgt){
            Integer x = list.get(lft);
            list.set(lft, list.get(rgt));
            list.set(rgt, x);
            lft++;
            rgt--;
        }
        System.out.println(list);
    }
}
