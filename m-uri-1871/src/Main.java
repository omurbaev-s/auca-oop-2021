import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int m, n;
        String s;

        while(inp.hasNextLine()) {
            m = inp.nextInt();
            n = inp.nextInt();

            if(m == 0 && n == 0) {
                break;
            }

            s = Integer.toString(m + n);
            s = s.replace("0", "");
            System.out.println(s);
        }
    }
}