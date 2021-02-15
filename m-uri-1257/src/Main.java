import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int value1=0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            int L = inp.nextInt();
            for(int j=0; j<L; j++){
                String s = inp.next();
                char[] b = s.toCharArray();
                for(int k=0; k< b.length; k++){
                    char ch = s.charAt(k);
                    int index =alphabet.indexOf(ch);
                    value1+=index+j+k;
                }
            }
            System.out.println(value1);
            value1=0;
        }
    }
}
