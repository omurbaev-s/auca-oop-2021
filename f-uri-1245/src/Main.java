import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNext()){
            int N = inp.nextInt();
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<String> side = new ArrayList<>();
        int counter = 0;
        for (int j = 0; j < N; j++) {
            int x = inp.nextInt();
            String y = inp.next();
            size.add(x);
            side.add(y);
        }
        for (int k = 0, t = 1; k < size.size() - 1; ) {
            if (size.get(k).equals(size.get(t))) {
                if (!side.get(k).equals(side.get(t))) {
                    counter++;
                    size.remove(k);
                    size.remove(t - 1);
                    side.remove(k);
                    side.remove(t - 1);
                    k = 0;
                    t = 1;
                } else {
                    t++;
                    if (t > size.size() - 1) {
                        k++;
                        t = k + 1;
                    }
                }
            } else {
                t++;
                if (t > size.size() - 1) {
                    k++;
                    t = k + 1;
                }
            }
        }
        System.out.println(counter);
    }
    }
}
