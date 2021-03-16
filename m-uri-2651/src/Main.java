import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String s = inp.next().toLowerCase(Locale.ROOT);
        if(s.contains("zelda")){
            System.out.println("Link Bolado");
        } else{
            System.out.println("Link Tranquilo");
        }
    }
}
