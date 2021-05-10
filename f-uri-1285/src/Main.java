import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            int N = inp.nextInt();
            int M = inp.nextInt();
            if (1 <= N && N <= M && M <= 5000){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = N; i <= M; i++) {
                    list.add(i);
                }
                String[] list2 = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    list2[i] = list.get(i).toString();
                }
                boolean count = false;
                int counter = 0;
                for (int i = 0; i < list2.length; i++) {
                    for (int j = 0, k = 1; j < list2[i].length() - 1; ) {
                        if (k < list2[i].length() && list2[i].charAt(j) != list2[i].charAt(k)) {
                            count = true;
                        } else {
                            count = false;
                            break;
                        }
                        k++;
                        if (k > list2[i].length() - 1) {
                            j++;
                            k = j + 1;
                        }
                    }
                    if (count) {
                        counter++;
                    }
                }

                System.out.println(counter);
            }
        }

    }
}
