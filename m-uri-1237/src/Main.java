import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNextLine()) {
            String s1 = inp.nextLine();
            String s2 = inp.nextLine();
            int counter = 0;
            for (int i = 0; i < s1.length(); ++i) {
                for (int j = i + 1; j <= s1.length(); ++j) {
                    String s = s1.substring(i, j);
                    if (s2.contains(s)) {
                        counter = Math.max(s.length(), counter);
                    }
                }
            }
            System.out.println(counter);
        }
    }
}