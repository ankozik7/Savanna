package project.plants;

public class Acacia extends Tree {
    String name = Acacia.class.getSimpleName();

    @Override
    public void show() {
        System.out.print(name);
        super.show();

    }
}