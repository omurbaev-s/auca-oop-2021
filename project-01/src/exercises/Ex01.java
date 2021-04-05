package exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter nonnegative integer: ");
        int n = inp.nextInt();

        System.out.println("Factorial of "+n+" is "+factorial(n));
    }

    private static BigInteger factorial(int n) {
        if(n==0){
            return BigInteger.ONE;
        } else{
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
}
