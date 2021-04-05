package exercises;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
         int num1 = inp.nextInt();
         int num2 = inp.nextInt();

        System.out.printf("gcd of %d and %d is %d", num1, num2, gcd(num1,num2));



    }

    private static int gcd(int num1, int num2) {
        if(num1%num2==0){
            return num2;
        } else{
            return gcd(num2, num1%num2);
        }
    }
}
