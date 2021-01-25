import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            String s = inp.next();
            char[] values = s.toCharArray();
            int shift = inp.nextInt();
            for(int j=0, k=0; j<values.length; k++){
                if(values[j]==alphabet[k]){
                    values[j]=alphabet[k-shift];
                    j++;
                    k=0;
                }

            }
            System.out.println(values);
        }
    }
}
