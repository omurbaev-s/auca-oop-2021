package console;

import java.util.Objects;

public class Flag {
    private int row;
    private int col;

    Flag(int row, int col){
        this.row=row;
        this.col=col;
    }

    @Override
    public String toString() {
        return String.format("Flag(%d, %d)", row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flag flag = (Flag) o;
        return row == flag.row && col == flag.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
