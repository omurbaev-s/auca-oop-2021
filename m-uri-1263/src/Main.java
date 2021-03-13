import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNextLine()) {
            String s = inp.nextLine().trim();
            ArrayList<String> list = new ArrayList<String>();
            for(int t =0, k=0; t< s.length();){
                if(s.charAt(t)==' '){
                    list.add(s.substring(k, t).toLowerCase(Locale.ROOT));
                    k=t+1;
                }
                t++;
                if(t==s.length()){
                    list.add(s.substring(k, t).toLowerCase(Locale.ROOT));
                }
            }


            int counter = 1;
            int counter1 = 0;

            for (int i = 0, j = 1; j < list.size(); ) {
                if (list.get(i).charAt(0) == list.get(j).charAt(0)) {
                    counter++;
                    i++;
                    j++;
                    if (counter == 2) {
                        counter1++;
                    }
                } else {
                    i++;
                    j++;
                    counter = 1;
                }
            }
            System.out.println(counter1);
        }
    }
}