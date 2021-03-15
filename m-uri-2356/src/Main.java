import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while(inp.hasNext()) {
            String DNA = inp.next();
            String code = inp.next();
            if(DNA.contains(code)){
                System.out.println("Resistente");
            } else {
                    System.out.println("Nao resistente");
                }
        }
    }
}
