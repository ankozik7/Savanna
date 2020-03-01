package project;



import project.animals.Animal;
import project.animals.Giraffe;
import project.animals.Lion;
import project.animals.Zebra;
import project.plants.Acacia;
import project.plants.Grass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Savanna {
    private Cell[][] cells;
    private int rows;
    private int cols;
    private List<Animal> animals;
    private List<Animal> preys;


    public Savanna(int rows, int cols, int trees, int giraffes, int zebras, int lions) {
        this.rows = rows;
        this.cols = cols;
        this.animals = new ArrayList<>();
        this.preys = new ArrayList<>();
        Random random = new Random();
        cells = new Cell[rows][cols];
        for (int i = 0; i < trees; i++) {
            int r, c;
            do {
                r = random.nextInt(rows);
                c = random.nextInt(cols);
            } while (cells[r][c] != null);
            cells[r][c] = Cell.withTree(new Acacia());
        }

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (cells[r][c] == null) {
                    cells[r][c] = Cell.withGrass(new Grass());
                }
            }
        }


        for (int i = 0; i < zebras; i++) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            Zebra zebra = new Zebra(r, c);
            animals.add(zebra);
            getConcreteCell(r, c).getCellAnimals().add(zebra);
        }

        for (int i = 0; i < giraffes; i++) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            Giraffe giraffe = new Giraffe(r, c);
            animals.add(giraffe);
            getConcreteCell(r, c).getCellAnimals().add(giraffe);
        }

        for (int i = 0; i < lions; i++) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            Lion lion = new Lion(r, c);
            animals.add(lion);
            getConcreteCell(r, c).getCellAnimals().add(lion);

        }

    }


    public Cell[][] getCells() {
        return cells;
    }

    public Cell getConcreteCell(int r, int c) {
        return cells[r][c];
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public List<Animal> getPreys() {
        return preys;
    }

    public void oneDay() {
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                cells[r][c].getPlant().grow();
            }
        }
        System.out.println("roślinki urosły");

    }

    @Override
    public String toString() {
        return "Zwierzęta" + animals;
    }
}

