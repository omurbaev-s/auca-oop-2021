import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;
        int M;
        while((N=inp.nextInt())!=0 && (M= inp.nextInt())!=0){
            int[] temp = new int[101];
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                list.add(inp.nextInt());
            }
            int counter=0;
            for(int i=0; i< list.size(); i++){
                int t = list.get(i);
                if(list.contains(t)){
                    temp[t]++;
                }
            }
            for(int i=0; i<temp.length; i++){
                if(temp[i]>=M){
                    counter++;
                }
            }
            System.out.println(counter);
        }

    }
}
