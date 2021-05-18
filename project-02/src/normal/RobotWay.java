package normal;

import java.util.Objects;

public class RobotWay {
    private int robotRow;
    private int robotCol;

    public RobotWay(int robotRow, int robotCol){
        this.robotRow=robotRow;
        this.robotCol=robotCol;
    }

    public int getRobotRow() {
        return robotRow;
    }

    public int getRobotCol() {
        return robotCol;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",robotRow, robotCol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotWay robotWay = (RobotWay) o;
        return robotRow == robotWay.robotRow && robotCol == robotWay.robotCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(robotRow, robotCol);
    }
}
