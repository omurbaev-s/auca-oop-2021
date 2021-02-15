import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String s = inp.next();
        String t1,t2;
        char[] v = s.toCharArray();
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        for(int i=0; i<v.length; i++){
            if(v[i]=='a' || v[i]=='e' || v[i]=='i' || v[i]=='o' || v[i]=='u'){
                b1.append(v[i]);
                b2.append(v[i]);
            }
        }
        b2.reverse();
        t1=b1.toString();
        t2=b2.toString();

        if(t1.equals(t2)){
            System.out.println("S");
        } else{
            System.out.println("N");
        }
    }
}
