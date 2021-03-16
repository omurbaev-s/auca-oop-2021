import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();
        inp.nextLine();
        for (int i = 0; i < N; i++) {
            String list = inp.nextLine();
            String breakfast = inp.nextLine();
            String lunch = inp.nextLine();

            String s1 = breakfast + lunch;
            int counter=0;
            for (int j = 0; j < s1.length(); j++) {
                if (list.indexOf(s1.charAt(j)) == -1) {
                    System.out.println("CHEATER");
                    counter++;
                    break;
                }
            }
            if(counter==0){
                StringBuilder diner = new StringBuilder();
                for (int t = 0; t < list.length(); t++) {
                    if (s1.indexOf(list.charAt(t)) == -1) {
                        diner.append(list.charAt(t));
                    }
                }
                String before = diner.toString();
                char[] array = before.toCharArray();
                Arrays.sort(array);
                System.out.println(array);
            }
        }
    }
}