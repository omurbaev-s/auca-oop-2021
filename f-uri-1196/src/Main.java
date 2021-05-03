import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String s1 = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

       while (inp.hasNext()) {
           StringBuilder words = new StringBuilder();
           String s = inp.nextLine();
           for (int i = 0; i < s.length(); i++) {
               if (s.charAt(i) == ' ') {
                   words.append(' ');
               } else if (s.charAt(i) != 'Q' && s.charAt(i) != 'A' && s.charAt(i) != 'Z' && s.charAt(i) != '`') {
                   int k = s1.indexOf(s.charAt(i));
                   words.append(s1.charAt(k - 1));
               }
           }
           System.out.println(words);
       }
    }
}
