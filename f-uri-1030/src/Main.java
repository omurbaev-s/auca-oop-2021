import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        int counter = 1;
        for(int i=0; i<N; i++){
            int nPeople = inp.nextInt();
            int step = inp.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=1; j<=nPeople; j++){
                list.add(j);
            }

            for(int k=0; list.size()>1;){
                if(k+(step-1) > list.size()-1){
                    int tempK = list.size()-(k);
                    int tempStep=(step-1)-tempK;
                    k=0;
                    if(k+tempStep> list.size()-1){
                        for(int t=0; t<tempStep; t++){
                            k++;
                            if(k>list.size()-1){
                                k=0;
                            }
                        }
                    } else {
                        k += tempStep;
                    }
                } else {
                    k += (step - 1);
                }

                       list.remove(k);

                if(k==list.size()){
                    k=0;
                }

            }
            int output = list.get(0);
            System.out.printf("Case %d: %s%n", counter, output);
            counter++;
        }
    }
}
