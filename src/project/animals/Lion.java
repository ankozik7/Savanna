package project.animals;

import project.Savanna;

public class Lion extends Predator {
    private String name = Lion.class.getSimpleName();
    private int row;
    private int col;

    public Lion(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void position() {
        System.out.print(name);
        super.position();
    }

    @Override
    public void move(Savanna savanna) {
        System.out.print(name + " ruszył się ");
        super.move(savanna);
    }

    @Override
    public void eat(Savanna savanna) {
        System.out.print(name);
        super.eat(savanna);
    }

    @Override
    public String toString() {
        return "Lion- komórka: " +
                row +
                ". " + col;
    }


    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }
}
