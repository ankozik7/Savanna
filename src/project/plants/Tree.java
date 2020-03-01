package project.plants;

public abstract class Tree implements Plant {
    int height;
    int branches;

    @Override
    public void grow() {
        height += 1;
        if (height < 5) {
            branches++;
        } else {
            branches += 2;
        }
    }

    @Override
    public void beEaten() {
        branches--;
        if (branches < 0) {
            branches = 0;
        }
    }

    @Override
    public void show() {
        System.out.print(" ma " + height + " m wysokości, a liczba gałęzi to:  " + branches);
        System.out.println(" ");

    }


}
