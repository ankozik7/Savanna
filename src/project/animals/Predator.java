package project.animals;



import project.Savanna;

import java.util.Random;

public abstract class Predator implements Animal {
    private int row;
    private int col;

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

    @Override
    public void eat(Savanna savanna) {
        Animal prey = savanna.getConcreteCell(this.getRow(), this.getCol()).hasHerbivore();
        if (prey == null) {
            System.out.println(" nie ma co zjeść");
        } else {
            System.out.println(" zjadł " + prey);
            savanna.getConcreteCell(this.getRow(), this.getCol()).getCellAnimals().remove(prey);
            savanna.getPreys().add(prey);
        }
    }

    @Override
    public void addAnimalToCell(Savanna savanna) {
        savanna.getConcreteCell(getRow(), getCol()).getCellAnimals().add(this);
    }

    @Override
    public void removeAnimalFromCell(Savanna savanna, int rows, int cols) {
        savanna.getConcreteCell(getRow()+rows, getCol() + cols).getCellAnimals().remove(this);
    }

    @Override
    public void move(Savanna savanna) {
        System.out.print(" z pozycji " + this.getRow() + ". " + this.getCol());
        Random random = new Random();
        int direction = Math.abs(random.nextInt(4));
        if (direction == 1 && getCol() > 1) {
            setCol(getCol() - 2);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,0,2);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 2 && getRow() > 1) {
            setRow(getRow() - 2);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,2,0);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 3 && savanna.getCols() > this.getCol() + 2) {
            setCol(getCol() + 2);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,0,(-2));
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 0 && savanna.getRows() > this.getRow() + 2) {
            setRow(getRow() + 2);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,(-2),0);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else {
            System.out.print("...jednak nie, zwierzak spróbuje jeszcze raz "+ "\n");
            move(savanna);
        }
    }

    @Override
    public void position() {
        System.out.print(" jest w rzędzie " + this.getRow() + "  w kolumnie " + this.getCol() + " "+ "\n");
    }

    @Override
    public void oneDay(Savanna savanna) {
        position();
        move(savanna);
        eat(savanna);
    }

    @Override
    public String toString() {
        return "Predator{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
