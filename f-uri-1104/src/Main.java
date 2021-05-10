import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int Alice;
        int Betty;
        while((Alice = inp.nextInt()) != 0 && (Betty = inp.nextInt()) != 0){
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();

            int x;
            for(int i=0; i< Alice; i++){
                a1.add(x = inp.nextInt());
            }
            for(int i=0; i< Betty; i++){
                a2.add(x = inp.nextInt());
            }
            int counter;
            if(a1.size()<=a2.size()) {
                counter = findNumber(a1, a2);
            } else{
                counter = findNumber(a2, a1);
            }
            System.out.println(counter);

        }


    }

    private static int findNumber(ArrayList<Integer> a1,ArrayList<Integer> a2) {
        int count=0;
        for (Integer integer : a1) {
            if (!a2.contains(integer)) {
                a2.add(integer);
                count++;
            }
        }
        return count;
    }
}
