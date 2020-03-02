package project.animals;



import project.Savanna;

import java.util.Random;

public abstract class Herbivore implements Animal {
    int row;
    int col;
    boolean eatGrass;
    boolean eatTree;

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
    public void addAnimalToCell(Savanna savanna) {
        savanna.getConcreteCell(getRow(), getCol()).getCellAnimals().add(this);
    }
    @Override
    public void removeAnimalFromCell(Savanna savanna, int rows, int cols) {
        savanna.getConcreteCell(getRow()+rows, getCol() + cols).getCellAnimals().remove(this);
    }

    public void getPlantToEat(Savanna savanna){
        savanna.getConcreteCell(this.getRow(), this.getCol()).getPlant().beEaten();
    }

    @Override
    public void eat(Savanna savanna) {
        String plant =  savanna.getConcreteCell(this.getRow(), this.getCol()).getPlant().getClass().getSimpleName();
        if (this.isEatGrass() && plant.equals("Grass")) {
            getPlantToEat(savanna);
            System.out.println(" zjadła trawę w komórce " + this.getRow() + ". " + this.getCol());
        } else if (this.isEatTree() && plant.equals("Acacia")) {
            getPlantToEat(savanna);
            System.out.println(" zjadła liście w komórce " + this.getRow() + ". " + this.getCol());
        } else {
            System.out.println("  nie miała co zjeść i jest głodna");
        }
    }

    @Override
    public void move(Savanna savanna) {
        System.out.print(" z pozycji " + this.getRow() + ". " + this.getCol());
        Random random = new Random();
        int direction = Math.abs(random.nextInt(4));
        if (direction == 1 && getCol() > 0) {
            this.setCol(this.getCol() - 1);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,0,1);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 2 && getRow() > 0) {
            this.setRow(getRow() - 1);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,1,0);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 3 && savanna.getCols() > this.getCol() + 1) {
            this.setCol(this.getCol() + 1);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,0,(-1));
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else if (direction == 0 && savanna.getRows() > this.getRow() + 1) {
            this.setRow(this.getRow() + 1);
            addAnimalToCell(savanna);
            removeAnimalFromCell(savanna,(-1),0);
            System.out.print(" na pozycję " + this.getRow() + ". " + this.getCol()+ "\n");
        } else {
            System.out.print("...jednak nie, zwierzak spróbuje jeszcze raz. ");
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
        return "Herbivore{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    public boolean isEatGrass() {
        return eatGrass;
    }

    public boolean isEatTree() {
        return eatTree;
    }
}
