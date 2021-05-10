import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while(inp.hasNext()) {
            int n = inp.nextInt();
            if (n % 6 == 0) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}

