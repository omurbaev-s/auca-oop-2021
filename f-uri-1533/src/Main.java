import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N;
       while ((N = inp.nextInt())!=0) {
           ArrayList<Integer> killers = new ArrayList<>();

           for (int i = 0; i < N; i++) {
               int x = inp.nextInt();
               killers.add(x);
           }

           int max = findMax(killers);
           killers.set(max,0);
           int killer = findMax(killers);

           System.out.println(killer + 1);
       }
    }

    private static int findMax(ArrayList<Integer> list) {
        int indexOfMax=0;
        for(int i=0, t=1; t< list.size();){
            if(list.get(t)>list.get(i)){
                indexOfMax= t;
                i=t;
                t++;
            } else{
                t++;
            }
        }
        return indexOfMax;
    }
}
