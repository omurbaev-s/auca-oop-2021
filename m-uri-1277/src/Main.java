import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int counter=0;

         int T = inp.nextInt();
         for(int i=0; i<T; i++){
             int N = inp.nextInt();
             String[] names = new String[N];
             String[] attendance = new String[N];
             int[] counter1 = new int[N];
             for(int j=0; j<N; j++){
                 names[j]=inp.next();
             }
             for(int j=0; j<N; j++){
                 attendance[j]=inp.next();
             }
             for(int j=0, k=0; j< N;){
                 if(attendance[j].charAt(k)=='A'){
                     counter++;
                 }
                 k++;
                 if(k>attendance[j].length()-1){
                     counter1[j]=counter;
                     k=0;
                     counter=0;
                     j++;
                 }
             }
             for(int j=0; j< attendance.length; j++) {
                 if (counter1[j]>1) {
                     System.out.print(names[j] + " ");
                 }
             }
             System.out.println();
         }
    }
}
