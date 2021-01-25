import java.util.*;

public class StringsAndArrays {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String s = inp.nextLine();
        char[] values = s.toCharArray();

        for(int i=0; i<values.length; i++){
            if(Character.isUpperCase(values[i])){
                values[i] = Character.toLowerCase(values[i]);
            } else if(Character.isLowerCase(values[i])){
                values[i] = Character.toUpperCase(values[i]);
            }
        }
        String r = new String(values);
        System.out.println(r);
    }
}
