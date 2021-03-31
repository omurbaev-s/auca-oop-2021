import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        float total=0;
        float average=0;
        for(int i=0; i<N; i++){
            float v = inp.nextFloat();
            total+=v;
            inp.nextLine();
            String fruits = inp.nextLine();
            int kg = 1;
            for(int j=0; j<fruits.length(); j++){
                if(fruits.charAt(j)==' '){
                    kg++;
                }
            }
            System.out.printf("day %d: %d kg\n", i+1, kg);
            average+=kg;
        }
        System.out.printf("%.2f kg by day\n", average/N);
        System.out.printf("R$ %.2f by day\n", total/N);
    }
}
