import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int N;
        while((N= inp.nextInt())!=0){
            String command = inp.next();
            String direction = "NLSO";
            int output=0;
            for(int i=0; i<command.length(); i++){
                if(command.charAt(i)=='D'){
                    output++;
                    if(output>direction.length()-1){
                        output=0;
                    }
                } else{
                    output--;
                    if(output<0){
                        output=direction.length()-1;
                    }
                }
            }
            System.out.println(direction.charAt(output));
        }
    }
}
