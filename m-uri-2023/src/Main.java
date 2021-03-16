import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<String>();
        while(inp.hasNext()) {
            list.add(inp.nextLine());
        }
        String[] temp = new String[list.size()];
        for(int i=0; i< temp.length;i++){
            temp[i]= list.get(i).toLowerCase(Locale.ROOT);
        }
        Arrays.sort(temp);


        for(int i=0; i< list.size(); i++){
            if(list.get(i).compareToIgnoreCase(temp[temp.length-1])==0){
                System.out.println(list.get(i));
            }
        }
    }
}
