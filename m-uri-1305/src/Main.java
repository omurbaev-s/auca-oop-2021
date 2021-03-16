import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in);
        while (inp.hasNext()){
            double num = Double.parseDouble(inp.nextLine());
            double cutoff = Double.parseDouble(inp.nextLine());
            if (num - (int) num >= cutoff) {
                num++;
            }
            System.out.println((int) num);
        }
    }
}