package p02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("StudentA", 2.6,1997),
                new Student("StudentB", 3.2,2003),
                new Student("StudentC", 1.2,2000)
        };

        Arrays.sort(students, new StudentComparatorByGPA());
        System.out.println(Arrays.toString(students));

        System.out.println("-----");

        Arrays.sort(students, new StudentComparatorByName());
        System.out.println(Arrays.toString(students));

        System.out.println("-----");

        Arrays.sort(students, Comparator.comparingInt(Student::getBirthYear));
        System.out.println(Arrays.toString(students));
    }
}
class StudentComparatorByGPA implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGPA(), o2.getGPA());
    }

}class StudentComparatorByName implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
    }
}

