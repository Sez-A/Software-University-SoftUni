package jediGalaxy;

public class WarField {
    private int[][] field;

    public WarField(int rows, int cols) {
        field = new int[rows][cols];
    }

    public void fillField() {
        int value = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = value++;
            }
        }
    }

    public void fight(Hero hero, Enemy enemy) {
            enemy.destroyed(this.field);
            hero.collect(this.field);
    }
}
