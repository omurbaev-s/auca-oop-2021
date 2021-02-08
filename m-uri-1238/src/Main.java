import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();
        int t =0;

        for (int i = 0; i < N; i++) {
            String s1= inp.next();
            String s2= inp.next();
            String last= "";
            String combined1 = s1+s2;
            char[] combined2 = combined1.toCharArray();

            if(s1.length()>=1 && s1.length()<=50 && s2.length()>=1 && s2.length()<=50) {
                if (s1.length() < s2.length() || s1.length() == s2.length()) {
                    for (int j = 0, k = 0; k < s1.length(); j++) {
                        combined2[j] = s1.charAt(k);
                        j++;
                        combined2[j] = s2.charAt(k);
                        k++;
                    }
                    System.out.println(combined2);
                } else {
                    for (int j = 0; j < s2.length(); j++) {
                        last += s1.charAt(j);
                        last += s2.charAt(j);
                        t++;
                    }
                    for (int j = t; j < s1.length(); j++) {
                        last += s1.charAt(j);
                    }
                    System.out.println(last);
                }
            }
        }
    }
}