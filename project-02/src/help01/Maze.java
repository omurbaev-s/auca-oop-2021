package help01;

public class Maze {
    private char[][] data;

    private int width;
    private int height;

    private int robotRow;
    private int robotCol;
    private int exitRow;
    private int exitCol;

    public Maze(char[][] level){
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
                    exitRow=r;
                    exitCol=c;
                    data[r][c]=' ';
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

    public int getExitCol() {
        return exitCol;
    }

    public int getExitRow() {
        return exitRow;
    }
    public char getCurElement(int row, int col){
        return data[row][col];
    }

    public void move(int dr, int dc ) {
        int tRow = robotRow+dr;
        int tCol = robotCol+dc;

        if(data[tRow][tCol]==' '){
            robotRow=tRow;
            robotCol=tCol;
        }
    }

    public boolean isWin() {
        return robotRow==exitRow && robotCol==exitCol;
    }
}
