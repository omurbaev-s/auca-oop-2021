import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] first = new int[5];
        int[] second = new int[5];
        for(int i=0; i<5; i++){
            first[i]= inp.nextInt();
        }
        for(int i=0; i<5; i++){
            second[i]= inp.nextInt();
        }
        int counter=0;
        for(int i=0; i< first.length; i++){
            if(first[i]!=second[i]){
                counter++;
            }
        }
        if(counter== first.length){
            System.out.println("Y");
        } else{
            System.out.println("N");
        }
    }
}
