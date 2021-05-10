import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();
        for(int i=0; i<N; i++){
            int origin=0;
            int nInst = inp.nextInt();
            inp.nextLine();
            ArrayList<String> list = new ArrayList<>();
            list.add("NOTHING");
            for(int j=0; j<nInst; j++){
                String first = inp.nextLine().trim();
                StringBuilder s = new StringBuilder();
                StringBuilder k = new StringBuilder();
                int n=0;
                for(int t=0; t<first.length(); t++){
                    if(Character.isLetter(first.charAt(t))){
                        s.append(first.charAt(t));
                    }else if(Character.isDigit(first.charAt(t))){
                        k.append(first.charAt(t));
                    }
                }
                if(k.length()!=0) {
                    n = Integer.parseInt(k.toString());
                }
                switch (s.toString()){
                    case "LEFT":
                        origin--;
                        list.add("LEFT");
                        break;
                    case "RIGHT":
                        origin++;
                        list.add("RIGHT");
                        break;
                    case "SAMEAS":
                        if(list.get(n).equals("LEFT")){
                            origin--;
                            list.add("LEFT");
                        } else if(list.get(n).equals("RIGHT")){
                            origin++;
                            list.add("RIGHT");
                        }

                }

            }
            System.out.println(origin);
        }
    }
}
