import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int counter=0;
        int counter1=0;
        int counter2=0;
        int counter3=0;

        while (inp.hasNextLine()) {
            counter = 0;
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            String str = inp.nextLine();
            char[] array = str.toCharArray();
            if (array.length >= 6 && array.length <= 32){
                for (char c : array) {
                    if (Character.isDigit(c)) {
                        counter1++;
                    }
                    if (!Character.isUpperCase(c)) {
                        counter++;
                    }
                    if (!Character.isLowerCase(c)) {
                        counter2++;
                    }
                    if (c == ' ') {
                        counter3++;
                    }
                }
        }
            if(counter!=0 && counter1!=0 && counter2!=0 && counter3==0){
                System.out.println("Senha valida.");
            } else{
                System.out.println("Senha invalida.");
            }
        }
    }
}