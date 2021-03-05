import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();

        for(int i=0; i<N; i++){
            String s1 = inp.next();
            String s2 = inp.next();

            if(s1.equals(s2)){
                System.out.println("empate");
            }else if(s1.equals("tesoura") && s2.equals("papel") || s1.equals("papel") && s2.equals("pedra") || s1.equals("pedra") && s2.equals("lagarto") || s1.equals("lagarto") && s2.equals("spock") || s1.equals("spock") && s2.equals("tesoura") || s1.equals("tesoura") && s2.equals("lagarto") || s1.equals("lagarto") && s2.equals("papel") || s1.equals("papel") && s2.equals("spock") || s1.equals("spock") && s2.equals("pedra") || s1.equals("pedra") && s2.equals("tesoura")){
                System.out.println("rajesh");
            } else{
                System.out.println("sheldon");
            }
        }
    }
}
