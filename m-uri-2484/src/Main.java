import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while(inp.hasNext()){
            StringBuilder s = new StringBuilder(inp.next().trim());
            String space="";
            for(int i=s.length()-1; i!=-1; i--){
                System.out.print(space);
                space+=" ";
                for(int j=0; j<s.length(); j++){
                    if(j==s.length()-1){
                        System.out.print(s.charAt(j)+"\n");
                    } else {
                        System.out.print(s.charAt(j) + " ");
                    }
                }
                s.deleteCharAt(i);
            }
            System.out.println();
        }
    }
}
