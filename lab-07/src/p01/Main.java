package p01;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int[] a1 = {5,1,3,0,2,4};
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        String[] a2 = {"Java","C++","C","Kotlin","Python","Scala"};
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a2));
        BigInteger[] a3 = {
                new BigInteger("1212121212121"),
                new BigInteger("15564655312"),
                new BigInteger("879798789")
        };
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));

        BigRational[] a4 = {
                BigRational.parse("7/4564546"),
                BigRational.parse("10/4587879"),
                BigRational.parse("78/98956")
        };
        Arrays.sort(a4);
        System.out.println(Arrays.toString(a4));
    }
}
