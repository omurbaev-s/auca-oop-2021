package easy;

import java.util.Objects;

public class Box {
    protected int bRow;
    protected int bCol;

    public Box(int bRow, int bCol){
        this.bRow=bRow;
        this.bCol=bCol;
    }

    public int getBRow() {
        return bRow;
    }

    public int getBCol() {
        return bCol;
    }
    @Override
    public String toString() {
        return String.format("%d, %d", getBRow(),getBCol());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return bRow == box.bRow && bCol == box.bCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bRow, bCol);
    }
}
