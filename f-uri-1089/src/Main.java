import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;
        while((N= inp.nextInt())!=0){
            int[] list = new int[N];
            for(int i=0; i<N; i++){
                list[i] = inp.nextInt();
            }
            int counter = 0;

            for(int i=0, t=1; i<N;){
                if (list[(t)%N] < list[i]) {
                    i++;
                    t++;
                    if(list[(t)%N]>list[(i)%N]){
                        counter++;
                    }

                } else {
                    i++;
                    t++;
                    if (list[(t) % N] < list[(i) % N]) {
                        counter++;
                    }
                }



            }
            System.out.println(counter);
        }

    }
}
