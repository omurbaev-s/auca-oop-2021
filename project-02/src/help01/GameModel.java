package help01;

public class GameModel {
    private int curLvl;

    Maze maze;

    private static char[][][] levels = {
            {
                    {'#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', 'E', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', 'R', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', '#', '#', '#', '#'},
            },
            {
                    {'#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#', 'E', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', 'R', '#', ' ', '#', ' ', '#'},
                    {'#', '#', '#', '#', '#', '#', '#'},
            },
            {
                    {'#', '#', '#', '#',  '#'},
                    {'#', ' ', ' ', ' ',  '#'},
                    {'#', ' ', '#', ' ',  '#'},
                    {'#', ' ', '#', ' ',  '#'},
                    {'#', ' ', '#', ' ',  '#'},
                    {'#', ' ', '#', ' ',  '#'},
                    {'#', 'E', '#', 'R',  '#'},
                    {'#', '#', '#', '#',  '#'},
            }
    };

    public GameModel(){
        this.curLvl=0;
        maze = new Maze(levels[curLvl]);
    }


    public void nextLevel() {
        curLvl++;
        if(curLvl== levels.length){
            curLvl=0;
        }
        maze=new Maze(levels[curLvl]);
    }

    public Object getCurLvl() {
        return curLvl+1;
    }
}
