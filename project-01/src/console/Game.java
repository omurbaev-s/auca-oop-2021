package console;


import java.util.ArrayList;

public class Game {
    int height;
    int width;
    int mines;
    int[][] data;
    boolean firstClick;
    boolean bomb;
    int row;
    int col;
    boolean win;
    boolean show;

    ArrayList<Flag> flags = new ArrayList<>();
    ArrayList<Flag> opened = new ArrayList<>();


    public Game(int height, int width, int mines) {
        if (height < 1) {
            throw new RuntimeException("Game: height is less than one: " + height);
        }
        if (width < 1) {
            throw new RuntimeException("Game: width is less than one: " + width);
        }
        if (mines < 1 || mines >= width * height) {
            throw new RuntimeException("Incorrect mode: mines >= width * height");
        }
        this.height = height;
        this.width = width;
        this.mines = mines;
        this.data = new int[height][width];
        this.firstClick = true;
        this.bomb=false;
        this.win=false;
        this.show=false;

    }

    @Override
    public String toString() {
        String header;
        if(height==9 && width==9 && mines==10) {
            header = String.format("Minesweeper: BEGINNER, height = %d, width = %d, mines = %d, flags = %d\n", height, width, mines, flags.size());
        } else if(height==16 && width==16 && mines==40){
            header = String.format("Minesweeper: INTERMEDIATE, height = %d, width = %d, mines = %d, flags = %d\n", height, width, mines, flags.size());
        } else if(height==16 && width==30 && mines==99){
            header = String.format("Minesweeper: EXPERT, height = %d, width = %d, mines = %d, flags = %d\n", height, width, mines, flags.size());
        } else{
            header = String.format("Minesweeper: CUSTOM, height = %d, width = %d, mines = %d, flags = %d\n", height, width, mines, flags.size());
        }
        StringBuilder r = new StringBuilder(header);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!bomb) {
                        if (flags.contains(new Flag(i, j))) {
                            r.append('F');
                        } else if (data[i][j] == -1) {
                            r.append('#');
                        } else if (isClear(i, j)) {
                            if (opened.contains(new Flag(i, j))) {
                                r.append(data[i][j]);
                            } else if(show){
                                if(data[i][j]==9){
                                    r.append('*');
                                } else {
                                    r.append('.');
                                }
                            } else {
                                r.append('.');
                            }
                        } else {
                            r.append(data[i][j]);
                        }
                } else {
                    if (data[i][j] == -1) {
                        data[i][j] = 0;
                    }
                    if (data[i][j] == 9) {
                        r.append('*');
                    } else {
                        r.append(data[i][j]);
                    }
                }
            }
            if (i != height - 1) {
                r.append("\n");
            }
        }
        show=false;
        win=isWin(r);
        return r.toString();
    }
    public boolean isWin(StringBuilder r) {
        int counter=0;
        int c=0;
        for(int i=0; i<r.length(); i++){
            if(r.charAt(i)=='.' || r.charAt(i)=='F'){
                counter++;
            }else if(r.charAt(i)=='*'){
                c++;
            }
        }
        if(counter==mines && c==0) {
            win = true;
        }
        return win;

    }

    private boolean isClear(int r, int c) {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        int clear=0;
        for (int i = 0; i < dr.length; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if (tr >= 0 && tr < height && tc >= 0 && tc < width && data[tr][tc]==-1){
                clear++;
            }
        }
        return clear == 0;
    }

    public void left(int row, int col) {

        if (row < 0 || row >= height) {
            throw new RuntimeException("Incorrect row: " + row+"\n");
        }
        if (col < 0 || col >= width) {
            throw new RuntimeException("Incorrect column: " + col+"\n");
        }


        if (firstClick) {
            int count = 0;
            while (count < mines) {

                int cRow = (int) (Math.random() * height);
                int cCol = (int) (Math.random() * width);
                while (cRow == row && cCol == col) {
                    cRow = (int) (Math.random() * height);
                    cCol = (int) (Math.random() * width);
                }
                if (data[cRow][cCol] == 9) {
                    continue;
                }
                data[cRow][cCol] = 9;
                count++;

            }
        }
        if (firstClick) {
            int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {

                    if (data[r][c] != 9) {
                        int nMines = 0;
                        for (int i = 0; i < dr.length; i++) {
                            int tr = r + dr[i];
                            int tc = c + dc[i];
                            if (tr >= 0 && tr < height && tc >= 0 && tc < width && data[tr][tc] == 9) {
                                nMines++;
                            }
                        }
                        data[r][c] = nMines;
                    }
                }
            }
        }
        if(data[row][col]==9){
            bomb=true;
        }
        if(data[row][col]!=9){
            this.row = row;
            this.col = col;
           opened.add(new Flag(row,col));
        }

        firstClick = false;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void floodFill(int row, int col) {
        if (row < 0 || row > height - 1 || col < 0 || col > width - 1) {
            return;
        }

        if (data[row][col] == 0) {
            data[row][col] = -1;

            floodFill(row + 1, col);
            floodFill(row, col + 1);
            floodFill(row - 1, col);
            floodFill(row, col - 1);

            floodFill(row - 1, col + 1);
            floodFill(row + 1, col + 1);
            floodFill(row + 1, col - 1);
            floodFill(row - 1, col - 1);
        }


    }

    public void right(int row, int col) {
        if (row < 0 || row >= height) {
            throw new RuntimeException("Incorrect row: " + row+"\n");
        }
        if (col < 0 || col >= width) {
            throw new RuntimeException("Incorrect column: " + col+"\n");
        }

        Flag flag = new Flag(row, col);

        if (flags.contains(flag)) {
            flags.remove(flag);
        } else {
            flags.add(flag);
        }


    }

    public void show() {
        show=true;
    }
}

