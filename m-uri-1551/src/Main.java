import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        int counter=0;
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        inp.nextLine();
        for(int i=0; i<N; i++){
            String s = inp.nextLine().toLowerCase();
            for(String letter : alphabet){
                if(s.contains(letter)){
                    counter++;
                }
            }
            if(counter==26){
                System.out.println("frase completa");
            } else if(counter>=13){
                System.out.println("frase quase completa");
            } else{
                System.out.println("frase mal elaborada");
            }
            counter=0;
        }
    }
}
