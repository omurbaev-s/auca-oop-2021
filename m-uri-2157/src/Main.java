import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int C = inp.nextInt();
        for(int i=0; i<C; i++){
            int E = inp.nextInt();
            int B = inp.nextInt();
            for(int j=E; j<=B; j++){
                System.out.print(j);
            }
            StringBuilder S = new StringBuilder();
            for(int k=E; k<=B; k++){
                S.append(k);
            }
            S.reverse();
            System.out.print(S);
            System.out.println();
        }
    }
}
