import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while(inp.hasNext()){
            int N = inp.nextInt();
            StringBuilder space = new StringBuilder();
            StringBuilder stars = new StringBuilder("*");
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<N/2; i++){
               space.append(" ");
            }
            temp.append(space);

            for(int i=0, k=space.length()-1; i< N; i+=2){
                System.out.print(space);
                if(k!=-1) {
                    space.deleteCharAt(k);
                }
                k=space.length()-1;

                System.out.print(stars);

                stars.append("**");
                System.out.println();
            }
               System.out.println(temp+"*");
               temp.deleteCharAt(temp.length()-1);
            System.out.println(temp+"***");
            System.out.println();
        }

    }
}
