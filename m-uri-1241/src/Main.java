import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();

        for(int i=0; i<N; i++){
            String A = inp.next();
            String B = inp.next();

            if(A.endsWith(B)){
                System.out.println("encaixa");
            } else{
                System.out.println("nao encaixa");
            }
        }
    }
}
