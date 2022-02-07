package jediGalaxy;

public class Enemy extends BaseEntity {

    public Enemy(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public int getStartRow() {
        return super.getStartRow();
    }

    @Override
    public int getStartCol() {
        return super.getStartCol();
    }

    public void destroyed(int[][] field) {
        while (this.getStartRow() >= 0 && this.getStartCol() >= 0) {
            if (this.getStartRow() < field.length && this.getStartCol() < field[0].length) {
                field[this.getStartRow()][this.getStartCol()] = 0;
            }
            this.setStartRow(this.getStartRow() - 1);
            this.setStartCol(this.getStartCol() - 1);
        }
    }
}
