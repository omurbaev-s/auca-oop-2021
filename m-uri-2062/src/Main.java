import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N = inp.nextInt();
        String[] array = new String[N];
        for(int i=0; i<N; i++){
            array[i]= inp.next().toUpperCase();
        }
        for(int i=0; i< array.length; i++){
            if(array[i].length()==3){
                if(array[i].startsWith("OB") || array[i].startsWith("UR")){
                    char[] ch = array[i].toCharArray();
                    ch[2]='I';
                    String str = new String(ch);
                    array[i]=str;
                }
            }
        }
            System.out.println(String.join(" ", array));
    }
}
