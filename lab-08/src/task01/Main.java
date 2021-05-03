package task01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        boolean nextInput=true;
        do {
            try {
                System.out.print("Enter an integer: ");
                int N = inp.nextInt();
                System.out.println("The number entered is " + N);
                nextInput=false;
            } catch (InputMismatchException e) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                inp.nextLine();
            }
        }while (nextInput);
    }
}
