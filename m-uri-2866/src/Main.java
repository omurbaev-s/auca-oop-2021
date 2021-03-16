import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            StringBuilder s = new StringBuilder(inp.next());
            StringBuilder s1 = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                if(Character.isLowerCase(s.charAt(j))){
                    s1.append(s.charAt(j));
                }
            }
            s1.reverse();
            System.out.println(s1);
        }
    }
}
