
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            int number = inp.nextInt();
            int[] list = new int[number];
            for(int j=0; j<number; j++){
                list[j]=inp.nextInt();
            }
            int counter=1;
            Arrays.sort(list);
            for(int j=0, t=1; t < list.length; j++, t++){
                if(list[j]!=list[t]){
                    counter++;
                }
            }

            System.out.println(counter);
        }
    }
}
