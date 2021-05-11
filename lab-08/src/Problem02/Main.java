package Problem02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner inp = new Scanner(System.in);
        int n ;
        while(true) {
            CircleWithException circle = new CircleWithException();
            n = circle.getNumberOfObjects();
            double a ;
            try {
                System.out.print("Enter a radius: ");
                double r = inp.nextDouble();

                circle.setRadius(r);
                a= circle.findArea();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
                break;
            }
            System.out.println("Number of objects created: " + n);
            System.out.println("Area = " + a);
        }
        System.out.println("Number of objects created: " + n);
    }
}