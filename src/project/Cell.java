package project;




import project.animals.Animal;
import project.animals.Herbivore;
import project.plants.Grass;
import project.plants.Plant;
import project.plants.Tree;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int row;
    private int column;
    private final Plant plant;
    private List<Animal> cellAnimals;

    private Cell(Plant plant) {
        this.plant = plant;
        this.cellAnimals = new ArrayList<>();

    }


    public static Cell withGrass(Grass grass) {
        return new Cell(grass);
    }

    public static Cell withTree(Tree tree) {
        return new Cell(tree);
    }

    public Plant getPlant() {
        return plant;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Animal> getCellAnimals() {
        return cellAnimals;
    }
    //sprawdzenie czy komórka zawiera zwierzeta roślinożerne
    public Animal hasHerbivore() {
        Animal herbivore = null;
        for (Animal animal : cellAnimals) {
            if (animal instanceof Herbivore) {
                herbivore = animal;
                break;
            }
        }
        return herbivore;
    }

    @Override
    public String toString() {
        return "Zwierzęta w komórce: " + cellAnimals;
    }
}

