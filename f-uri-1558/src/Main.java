import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()){
        int n = inp.nextInt();
        boolean can=false;
        for(int i=0; i*i<=n; i++) {
            for (int j = 0; j * j <= n; j++) {
                if (i * i + j * j == n) {
                    can=true;
                }
            }
        }
        if(can){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
