import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();

        for(int i=0; i<N; i++){
            int K = inp.nextInt();
            String[] array = new String[K];
            for(int j=0; j< array.length; j++){
                array[j] = inp.next();
            }
            int counter=1;
            String s;
            for(int k=0, t=1; t< array.length;){
                if(array[k].equals(array[t])){
                    counter++;
                } else{
                    System.out.println("ingles");
                    break;
                }
                t++;
            }
            if(counter==K){
                System.out.println(array[0]);
            }
        }
    }
}
