import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;
        int M;
        while((N= inp.nextInt())!=0 && (M= inp.nextInt())!=0){
            int[] inBag = new int[M];
            for(int i=0; i<M; i++){
                inBag[i]= inp.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i< inBag.length; i++){
                for(int j=i+1; j< inBag.length; j++){
                    list.add(Math.abs(inBag[i]-inBag[j]));
                }
            }
            int counter=0;
            for(int i=1; i<=N; i++){
                if(list.contains(i)){
                    counter++;
                }
            }
            if(counter==N){
                System.out.println("Y");
            } else{
                System.out.println("N");
            }
        }
    }
}
