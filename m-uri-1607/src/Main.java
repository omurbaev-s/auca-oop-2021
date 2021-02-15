import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int T = inp.nextInt();
        for(int i=0; i<T; i++){
            String s1 = inp.next();
            String s2 = inp.next();
            char[] b1 = s1.toCharArray();
            char[] b2 = s2.toCharArray();

            int k=0;
            for(int j=0; j< b1.length;){
                if(b1[j]=='z'){
                    if(b1[j]+1!='a') {
                        b1[j]='`';
                    }
                }
                if(b1[j]!=b2[j]){
                    b1[j]++;
                    k++;
                } else{
                    j++;
                }
            }
            System.out.println(k);
        }
    }
}
