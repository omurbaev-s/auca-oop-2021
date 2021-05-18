package normal;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class Maze {
    private char[][] data;

    private int width;
    private int height;
    private int moves;

    private int robotRow;
    private int robotCol;
    private ArrayList<RobotWay> robotWay;
    private ArrayList<BufferedImage> directions;
    protected ArrayList<Exit> exits;
    protected ArrayList<Box> boxes;
    private ArrayList<BoxWay>[] boxWay;

    public Maze(char[][] level){
        robotWay= new ArrayList<>();
        directions=new ArrayList<>();
        boxes=new ArrayList<>();
        exits=new ArrayList<>();
        height=level.length;
        width=level[0].length;
        data = new char[height][width];
        moves=0;

        for(int r=0; r<height; r++){
            for(int c=0; c<width; c++){
                if(level[r][c]=='R'){
                    robotWay.add(new RobotWay(r,c));
                    robotRow=r;
                    robotCol=c;
                    data[r][c]=' ';
                } else if(level[r][c]=='E'){
                    exits.add(new Exit(r,c));
                    data[r][c]=' ';
                } else if(level[r][c]=='B'){
                    boxes.add(new Box(r,c));
                    data[r][c]='B';
                } else{
                    data[r][c]=level[r][c];
                }
            }
        }
        boxWay = new ArrayList[boxes.size()];
        for(int i=0; i<boxes.size(); i++){
             boxWay[i] = new ArrayList<>();
             boxWay[i].add(new BoxWay(boxes.get(i).getBRow(),boxes.get(i).getBCol()));
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


    public void move(int dr, int dc, BufferedImage direction) {
        int tRow = robotRow+dr;
        int tCol = robotCol+dc;
        int bRow = tRow+dr;
        int bCol = tCol+dc;
        int r = boxes.indexOf(new Box(tRow,tCol));
        directions.add(direction);

        if(data[tRow][tCol]==' '){
            robotRow=tRow;
            robotCol=tCol;
            robotWay.add(new RobotWay(robotRow,robotCol));
            moves++;
        }else if (data[tRow][tCol] == 'B' && data[bRow][bCol] == ' ' ) {

                robotRow = tRow;
                robotCol = tCol;
                robotWay.add(new RobotWay(robotRow,robotCol));
                boxWay[r].add(new BoxWay(bRow,bCol));
                boxes.set(r,new Box(bRow, bCol));
                data[tRow][tCol] = ' ';
                data[bRow][bCol] = 'B';
            moves++;
            }

        System.out.println(Arrays.toString(boxWay));
        System.out.println(robotWay);


    }
    public void undo() {
        int curRobot;
        int counter = 0;
        for (int i = 0; i < robotWay.size(); i++) {
            if (robotWay.get(i).equals(new RobotWay(robotRow, robotCol))) {
                counter++;
            }
        }
            if (counter == 0) {
                curRobot = robotWay.indexOf(new RobotWay(robotRow, robotCol));
            } else {
                curRobot = robotWay.lastIndexOf(new RobotWay(robotRow, robotCol));
            }
            if (curRobot != 0) {
                robotRow = robotWay.get(curRobot - 1).getRobotRow();
                robotCol = robotWay.get(curRobot - 1).getRobotCol();
                robotWay.add(new RobotWay(robotRow, robotCol));
            }
        }



    public int getMoves() {
        return moves;
    }

    public boolean isWin() {
        boolean win=false;
        for(int i=0; i<boxes.size(); i++){

                if (exits.contains(new Exit(boxes.get(i).getBRow(),boxes.get(i).getBCol()))/*boxRow.get(j) == exits.get(i).getExitRow() && boxCol.get(j) == exits.get(i).getExitCol()*/) {
                    win = true;

                } else {
                    win=false;
                    break;
                }
        }
        return win;

    }

}
