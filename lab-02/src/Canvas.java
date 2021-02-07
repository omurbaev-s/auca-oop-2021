public class Canvas {
    public static final int SIZE = 20;

    private char[][] data;

    public Canvas(){
        data = new char[SIZE][SIZE];
        for(int row = 0; row< SIZE; row++){
            for(int col = 0; col< SIZE; col++){
                data[row][col]='.';
            }
        }
    }

    public void set(int row, int col) {
        if(row<0 || SIZE<=row || col<0 || SIZE<=col){
            throw new RuntimeException("Canvas: coordinates are out of Canvas");
        }
        data[row][col]='*';
    }

    public void show() {
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
    public boolean isOnCanvas(int row, int col) {
        return 0<=row && row<SIZE && 0<=col && col<SIZE;
    }
}
