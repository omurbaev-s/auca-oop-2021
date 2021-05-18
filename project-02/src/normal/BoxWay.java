package normal;

import java.util.Objects;

public class BoxWay {
    private int boxRow;
    private int boxCol;

    public BoxWay(int boxRow, int boxCol){
        this.boxRow=boxRow;
        this.boxCol=boxCol;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",boxRow, boxCol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxWay boxWay = (BoxWay) o;
        return boxRow == boxWay.boxRow && boxCol == boxWay.boxCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxRow, boxCol);
    }
}
