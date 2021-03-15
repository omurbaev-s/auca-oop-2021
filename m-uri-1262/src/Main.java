import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNext()) {
            String s = inp.nextLine();
            int N = Integer.parseInt(inp.nextLine());
            int proc = 0;
            int counter = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'R') {
                    if (proc == 0) {
                        counter++;
                    }

                    proc++;

                    if (proc == N) {
                        proc = 0;
                    }

                } else {
                    counter++;
                    proc = 0;
                }
            }

            System.out.println(counter);
        }
    }
}