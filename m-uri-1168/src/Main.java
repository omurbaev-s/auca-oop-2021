import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String number;
        int led = 0;
        int N = inp.nextInt();

        for(int i=1; i<=N; i++){
            number= inp.next();
            for(int j=0; j<number.length(); j++){
                if(number.charAt(j)=='1'){
                    led += 2;
                } if(number.charAt(j)=='2' || number.charAt(j)=='3' || number.charAt(j)=='5'){
                    led += 5;
                } if(number.charAt(j)=='4'){
                    led += 4;
                } if(number.charAt(j)=='6' || number.charAt(j)=='9' || number.charAt(j)=='0'){
                    led += 6;
                } if(number.charAt(j)=='7'){
                    led += 3;
                } if(number.charAt(j)=='8'){
                    led += 7;
                }
            }
            System.out.println(led+" leds");
            led = 0;

        }


    }
}
