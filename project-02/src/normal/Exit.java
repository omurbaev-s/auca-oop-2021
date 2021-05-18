package normal;

import java.util.Objects;

public class Exit {
    private int exitRow;
    private int exitCol;

    public Exit(int exitRow, int exitCol){
        this.exitRow=exitRow;
        this.exitCol=exitCol;
    }

    public int getExitRow() {
        return exitRow;
    }
    public int getExitCol() {
        return exitCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exit exit = (Exit) o;
        return exitRow == exit.exitRow && exitCol == exit.exitCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exitRow, exitCol);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d) ", exitRow,exitCol);
    }
}
