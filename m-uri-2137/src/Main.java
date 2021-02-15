import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

            int N = inp.nextInt();
            String[] code = new String[N];
            for (int i = 0; i < N; i++) {
                code[i] = inp.next();
            }
            Arrays.sort(code);
            for (int i = 0; i < code.length; i++) {
                System.out.println(code[i]);
            }
        }
    }

