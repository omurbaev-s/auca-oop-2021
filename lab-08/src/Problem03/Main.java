package Problem03;

public class Main {
    public static void main(String[] args) {

            try {
                new CircleWithCustomException(5);
                new CircleWithCustomException(1);
                new CircleWithCustomException(-1);
            } catch (InvalidRadiusException ex) {
                System.out.println(ex);
            }
            System.out.println("Number of objects created: " + CircleWithCustomException.getNumberOfObjects());
    }
}