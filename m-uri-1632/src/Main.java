import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            int counter=1;
            String s = inp.next().toUpperCase(Locale.ROOT);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='A' || s.charAt(j)=='E' || s.charAt(j)=='I' || s.charAt(j)=='O' || s.charAt(j)=='S'){
                    counter*=3;
                } else{
                    counter*=2;
                }
            }
            System.out.println(counter);
        }
    }
}
