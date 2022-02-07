package jediGalaxy;

public class Hero extends BaseEntity {

    private int points;

    public Hero(int startRow, int startCol) {
        super(startRow, startCol);
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int getStartRow() {
        return super.getStartRow();
    }

    @Override
    public int getStartCol() {
        return super.getStartCol();
    }

    public int collect(int[][] field) {
        while (this.getStartRow() >= 0 && this.getStartCol() < field[1].length) {
            if (this.getStartCol() >= 0 && this.getStartRow() < field.length
                    && this.getStartCol() >= 0 && this.getStartCol() < field[0].length) {
                this.points += field[this.getStartRow()][this.getStartCol()];
            }

            this.setStartRow(this.getStartRow() - 1);
            this.setStartCol(this.getStartCol() + 1);
        }
        return this.getPoints();
    }
}
