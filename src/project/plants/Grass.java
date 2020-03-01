package project.plants;

public class Grass implements Plant {
    int size = 0;

    @Override
    public void grow() {
        size += 2;
    }

    @Override
    public void beEaten() {
        size -= 2;
        if (size < 0) {
            size = 0;
        }
    }

    @Override
    public void show() {
        System.out.println("Trawa jest rozmiaru  " + size);
    }
}

