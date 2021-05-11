import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        int counter=1;
        for(int m=0; m<N; m++){
            int[][] array = new int[9][9];
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    array[i][j]= inp.nextInt();
                }
            }
            boolean c3= each(array);
            boolean c1= horizontal(array);
            boolean c2= vertical(array);

            if(c1 && c2 && c3){
                System.out.println("Instancia "+counter);
                System.out.println("SIM");
                System.out.println();
            } else{
                System.out.println("Instancia "+counter);
                System.out.println("NAO");
                System.out.println();
            }
            counter++;
            }
        }

    private static boolean each(int[][] array) {
        boolean end = true;
        int c=0;
        int c1=0;
        for(int i=0, t=0; i<9;){
            ArrayList<Integer> list = new ArrayList<>();
            int[] counter = new int[10];
            for(int j=0; j<3; ){
                list.add(array[i][t]);
                t++;
                if(t>=3+c){
                    t=c;
                    j++;
                    i++;
                }
            }
            i=c1;
            c+=3;
            t+=3;
            if(t>=9){
                c1+=3;
                t=0;
                c=0;
            }
            for(int k=0; k< list.size(); k++){
                int temp= list.get(k);
                if(list.contains(temp)){
                    counter[temp]++;
                }
            }
            for (int j : counter) {
                if (j > 1) {
                    end = false;
                    break;
                }
            }
        }
        return end;
    }

    private static boolean vertical(int[][] array) {
        boolean end = true;
        for(int i=0, t=0; t<9; t++){
            ArrayList<Integer> check = new ArrayList<>();
            int[] counter = new int[10];
            for(int j=0; j<9; j++, i++) {
                check.add(array[i][t]);
            }
            i=0;
            for(int k=0; k< check.size(); k++){
                int temp = check.get(k);
                if(check.contains(check.get(k))){
                    counter[temp]++;
                }
            }
            for (int j : counter) {
                if (j > 1) {
                    end = false;
                    break;
                }
            }
        }
        return end;
    }

    private static boolean horizontal(int[][] array) {
        boolean end = true;
        for(int i=0; i<9; i++){
            ArrayList<Integer> check = new ArrayList<>();
            int[] counter = new int[10];
            for(int j=0; j<9; j++){
                check.add(array[i][j]);
            }
            for(int t=0; t< check.size(); t++){
                int temp = check.get(t);
                if(check.contains(check.get(t))){
                    counter[temp]++;
                }
            }
            for (int j : counter) {
                if (j > 1) {
                    end = false;
                    break;
                }
            }
            if(!end){
                break;
            }
        }
        return end;
    }
}

