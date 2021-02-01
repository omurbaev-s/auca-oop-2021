import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextLine()) {
            boolean upper = true;
            StringBuilder s = new StringBuilder(inp.nextLine());
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isAlphabetic(c)) {
                    if (upper){
                        s.setCharAt(i, Character.toUpperCase(c));
                    } else{
                        s.setCharAt(i, Character.toLowerCase(c));
                    }
                    upper =! upper;
                }
            }
            System.out.println(s);
        }
    }

}