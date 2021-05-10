package p03;

import p02.Student;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int[] a1={5,2,3,4,1};
        MyArrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        double[] a2={5.4,2.2,3.6,4.7,1.3};
        MyArrays.sort(a2);
        System.out.println(Arrays.toString(a2));

        BigRational[] a3 = {
                BigRational.parse("7/4564546"),
                BigRational.parse("10/4587879"),
                BigRational.parse("78/98956")
        };
        MyArrays.sort(a3);
        System.out.println(Arrays.toString(a3));
        Student[] students = {
                new Student("StudentA", 2.6,1997),
                new Student("StudentB", 3.2,2003),
                new Student("StudentC", 1.2,2000)
        };

        MyArrays.sort(students, new StudentComparatorByGPA());
        System.out.println(Arrays.toString(students));

        System.out.println("-----");

        MyArrays.sort(students, new StudentComparatorByName());
        System.out.println(Arrays.toString(students));

        System.out.println("-----");

        MyArrays.sort(students, ((o1, o2) -> {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return Integer.compare(s1.getBirthYear(), s2.getBirthYear());
        }));
        System.out.println(Arrays.toString(students));
    }
}

class StudentComparatorByGPA implements MyComparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return Double.compare(s1.getGPA(), s2.getGPA());
    }

}class StudentComparatorByName implements MyComparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getName().compareTo(s2.getName());
    }
}
