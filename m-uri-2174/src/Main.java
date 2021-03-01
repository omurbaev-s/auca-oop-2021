import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String pokemons;
        int counter =151;

        int N = inp.nextInt();
        inp.nextLine();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0; i<N; i++) {
            pokemons = inp.nextLine();
            if (!arrayList.contains(pokemons)) {
                arrayList.add(pokemons);
            }
        }
        counter-= arrayList.size();
        System.out.printf("Falta(m) %d pomekon(s).%n", counter);
    }
}