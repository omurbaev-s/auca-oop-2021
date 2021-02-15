import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        inp.nextLine();

        for(int i=0; i<N; i++){
            String s = inp.nextLine();
            char[] values = s.toCharArray();
            for(int j=0; j< values.length; j++){
                if(Character.isLetter(values[j])){
                    values[j]+=3;
                }
            }
            StringBuilder b = new StringBuilder(new String(values));
            b.reverse();
            for(int j=b.length()-1; j>=b.length()/2; j--){
                b.setCharAt(j, (char) (b.charAt(j)-1));
            }
            System.out.println(b);
        }
    }
}