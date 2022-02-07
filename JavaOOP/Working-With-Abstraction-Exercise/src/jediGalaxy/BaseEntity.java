package jediGalaxy;

public abstract class BaseEntity {
    private int startRow;
    private int startCol;

    protected BaseEntity(int startRow, int startCol) {
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }
}
