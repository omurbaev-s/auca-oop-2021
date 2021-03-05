import java.util.*;

public class Problem02 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (inp.hasNextInt()){
            int x = inp.nextInt();
            list.add(x);
        }
        for(int i=0; i< list.size();){
            if(list.get(i)%2==0){
                list.add(i,0);
                i+=2;
            } else{
                i++;
            }
        }
        System.out.println(list);

        for(int i=0; i< list.size(); i++){
            if(list.get(i)%2!=0){
                list.remove(i);
                i--; 
            }
        }

        System.out.println(list);
    }
}
