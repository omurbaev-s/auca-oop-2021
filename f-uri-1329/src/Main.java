import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;
        while ((N = inp.nextInt()) != 0) {
            int Mary = 0;
            int John = 0;
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = inp.nextInt();
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    Mary++;
                } else {
                    John++;
                }
            }
            System.out.printf("Mary won %d times and John won %d times\n", Mary, John);
        }
    }
}
