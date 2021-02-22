import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int lWord=0;
        int N = inp.nextInt();

        while(N!=0){
            String[] array = new String[N];
            for(int i=0; i<N; i++) {
                array[i]= inp.next().toUpperCase();
                if(array[i].length()>lWord){
                    lWord=array[i].length();
                }
            }
            for(int j=0; j<N; j++){
                for(int k=0; k<(lWord-array[j].length()); k++){
                    System.out.print(" ");
                }
                System.out.println(array[j]);
            }
            System.out.println();
            lWord=0;
            N = inp.nextInt();
        }
    }
}
