package easy;

import java.util.ArrayList;

public class Maze {
    private char[][] data;

    private int width;
    private int height;

    private int robotRow;
    private int robotCol;
    private ArrayList<Integer> boxRow;
    private ArrayList<Integer> boxCol;
    protected ArrayList<Exit> exits;
    protected ArrayList<Box> boxes;

    public Maze(char[][] level){
        boxes=new ArrayList<>();
        exits=new ArrayList<>();
        boxRow=new ArrayList<>();
        boxCol=new ArrayList<>();
        height=level.length;
        width=level[0].length;
        data = new char[height][width];

        for(int r=0; r<height; r++){
            for(int c=0; c<width; c++){
                if(level[r][c]=='R'){
                    robotRow=r;
                    robotCol=c;
                    data[r][c]=' ';
                } else if(level[r][c]=='E'){
                    exits.add(new Exit(r,c));
                    data[r][c]=' ';
                } else if(level[r][c]=='B'){
                    boxRow.add(r);
                    boxCol.add(c);
                    boxes.add(new Box(r,c));
                    data[r][c]='B';
                } else{
                    data[r][c]=level[r][c];
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char get(int row, int col) {
        return data[row][col];
    }

    public int getRobotCol() {
        return robotCol;
    }

    public int getRobotRow() {
        return robotRow;
    }

    public char getCurElement(int row, int col){
        return data[row][col];
    }

    public void move(int dr, int dc) {
        int tRow = robotRow+dr;
        int tCol = robotCol+dc;
        int bRow = tRow+dr;
        int bCol = tCol+dc;

//        int cRow = boxRow.indexOf(tRow);
//        int cCol = boxCol.indexOf(tCol);
        int r = boxes.indexOf(new Box(tRow,tCol));

        System.out.println(r);
        System.out.println(tRow+" "+tCol);

        if(data[tRow][tCol]==' '){
            robotRow=tRow;
            robotCol=tCol;
        }else if (data[tRow][tCol] == 'B' && data[bRow][bCol] == ' ' ) {

                robotRow = tRow;
                robotCol = tCol;
//                boxRow.set(cRow,bRow);
//                boxCol.set(cCol,bCol);

                boxes.set(r,new Box(bRow, bCol));
                data[tRow][tCol] = ' ';
                data[bRow][bCol] = 'B';
            }
        System.out.println(boxes);
        System.out.println(exits);
    }

//    public int getBoxRow() {
//        return boxRow;
//    }
//
//    public int getBoxCol() {
//        return boxCol;
//    }

    public boolean isWin() {
        int counter=0;
        boolean win=false;
        for(int i=0; i<boxes.size(); i++){

                if (exits.contains(new Exit(boxes.get(i).getBRow(),boxes.get(i).getBCol()))/*boxRow.get(j) == exits.get(i).getExitRow() && boxCol.get(j) == exits.get(i).getExitCol()*/) {
                    win = true;

                } else {
                    break;
                }


        }


        return win;

    }

}
