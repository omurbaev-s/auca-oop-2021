import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();
        inp.nextLine();

        for(int i=0; i<N; i++){
            String s = inp.nextLine();

            StringBuilder b1 = new StringBuilder(s.substring(0, s.length()/2));
            StringBuilder b2 = new StringBuilder(s.substring(s.length()/2, s.length()));

            b1.reverse();
            b2.reverse();

            System.out.println(b1.toString()+b2.toString());
        }
    }
}
