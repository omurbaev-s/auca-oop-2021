import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N;

        while((N= inp.nextInt())!=0){
            int correct=0;
            int time=0;
            String[] array1 = new String[N];
            String[] array2 = new String[N];

            for(int i=0; i<N; i++){
                String ch = inp.next();
                int T = inp.nextInt();
                String s = inp.next();

                if(s.equals("correct")){
                    correct++;
                    time+=T;
                }

                array1[i]=ch;
                array2[i]=s;
            }
            for(int i=0; i<N; i++){
                if(i==array1.length-1){
                    break;
                }
            if(array2[i].equals("incorrect")){
                for(int j=i, k=j+1; k<N;){
                    if(array1[j].equals(array1[k]) && array2[k].equals("correct")){
                        time+=20;
                        break;
                    } else {
                        k++;
                    }
                }
            }
            }

            System.out.print(correct+" "+time+"\n");
        }
    }
}
