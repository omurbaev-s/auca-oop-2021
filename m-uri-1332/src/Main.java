import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        for(int i=0; i<n; i++){
            String s = inp.next();
            if(s.length()==5){
                System.out.println(3);
            } else{
                int nDiff = 0;
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j)!="one".charAt(j)){
                        nDiff++;
                    }
                }
                System.out.println(nDiff<2? 1:2);
            }
        }
    }
}
