import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int caso = 1;
        while (inp.hasNext()) {
            int N = inp.nextInt();
            int M = 0;
            int F = 0;
            int total = 0;
            String s;
            String temp;
            ArrayList<Integer> size = new ArrayList<Integer>();
            StringBuilder digit = new StringBuilder();
            StringBuilder letter = new StringBuilder();
            StringBuilder list = new StringBuilder();
            inp.nextLine();
            list.append(s= inp.nextLine());
            for(int i=0; i< list.length();i++){
                if(Character.isDigit(list.charAt(i))){
                    digit.append(list.charAt(i));
                    if(i< list.length()){
                        if(!Character.isDigit(list.charAt(i+1))){
                            temp=digit.toString();
                            size.add(Integer.parseInt(temp));
                            digit.setLength(0);
                        }
                    }
                } else if(Character.isLetter(list.charAt(i))){
                    letter.append(list.charAt(i));
                }
            }

            for (int i = 0; i < size.size(); i++) {
                if (size.get(i) == N) {
                    total++;
                    if (letter.charAt(i)=='M') {
                        M++;
                    } else {
                        F++;
                    }
                }
            }

            if(caso!=1){
                System.out.println();
            }
            System.out.printf("Caso %d:\n", caso);
            System.out.printf("Pares Iguais: %d\n", total);
            System.out.printf("F: %d\n", F);
            System.out.printf("M: %d\n", M);
            caso++;
        }
    }
}
