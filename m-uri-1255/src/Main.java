import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

        int tests = inp.nextInt();
        inp.nextLine();

        for(int test=0; test<tests; test++){
            String s = inp.nextLine();
            int[] counters = new int[alphabet.length()];
            int maxCounter=0;
            for(int i=0; i<s.length(); i++){
                char ch = Character.toLowerCase(s.charAt(i));
                int index =alphabet.indexOf(ch);
                if(index != -1){
                    maxCounter = Math.max(++counters[index], maxCounter);

                }
            }
            for(int i=0; i<counters.length; i++){
                if(counters[i] == maxCounter){
                    System.out.print(alphabet.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
