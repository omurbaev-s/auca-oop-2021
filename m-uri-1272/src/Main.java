import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        int N=inp.nextInt();
        String s= inp.nextLine();
        for (int i=0;i<N;i++){
            s=inp.nextLine();

            for(int j=0; j<s.length();){
                while(j<s.length() && s.charAt(j)==' '){
                    j++;
                }
                if(j<s.length())
                    System.out.print(s.charAt(j));
                while(j<s.length() && s.charAt(j)!=' '){
                    j++;
                }
            }
            System.out.println();
        }
    }
}