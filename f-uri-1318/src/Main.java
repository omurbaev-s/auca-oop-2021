import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner((System.in));
        int tickets;
        int people;
        while((tickets= inp.nextInt())!=0 && (people= inp.nextInt())!=0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<people; i++){
                int x= inp.nextInt();
                list.add(x);
            }
            int counter=0;
            int occurrence=0;
            for(int i=0, t=1; list.size()>1;){
                if(list.get(i).equals(list.get(t))){
                    occurrence++;
                    if(occurrence<2) {
                        counter++;
                    }
                    list.remove(t);
                }else{
                    t++;
                }
                if(t >= list.size()-1){
                    list.remove(i);
                    occurrence=0;
                    i=0;
                    t=1;
                }
            }
            System.out.println(counter);
        }
    }
}
