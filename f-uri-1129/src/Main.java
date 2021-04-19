import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;
        String grade = "ABCDE";
        while ((N= inp.nextInt())!=0){
            int[] array = new int[5];
            for(int i=0; i<N; i++){
                int counter=0;
                int counter1=0;
                for(int j=0; j< array.length; j++){
                    array[j]= inp.nextInt();
                }
                for(int j=0;j< array.length; j++){
                    if(array[j]<=127){
                        counter=j;
                        counter1++;
                    }
                }
                if(counter1>1 || counter1==0){
                    System.out.println("*");
                }else {
                    System.out.println(grade.charAt(counter));
                }
            }
        }
    }
}
