import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            String s = inp.next();

            StringBuilder d = new StringBuilder();
            int counter=0;
            for(int j=0; j<s.length(); j++) {
                if (j != s.length() - 1){
                    if (Character.isDigit(s.charAt(j)) && Character.isLetter(s.charAt(j + 1))) {
                        d.append(s.charAt(j));
                        counter += Integer.parseInt(d.toString());
                    }
                if (Character.isDigit(s.charAt(j)) && Character.isDigit(s.charAt(j + 1))) {
                    d.append(s.charAt(j));
                }
                if (d.length() > 0 && Character.isLetter(s.charAt(j))) {
                    d.delete(0, d.length());
                }
            }
                if(j==s.length()-1 && Character.isDigit(s.charAt(j)) && Character.isDigit(s.charAt(j-1))){
                    d.append(s.charAt(j));
                    counter+=Integer.parseInt(d.toString());
                } else if(j==s.length()-1 && !Character.isLetter(s.charAt(j))){
                    counter+=Character.getNumericValue(s.charAt(j));
                }
            }
            System.out.println(counter);
        }
    }
}
