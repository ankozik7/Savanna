package project.animals;


import project.Savanna;

public class Giraffe extends Herbivore {
        private String name = Giraffe.class.getSimpleName();
        private int row;
        private int col;
        private boolean eatGrass = false;
        private boolean eatTree = true;

        public Giraffe(int row, int col) {
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
            System.out.print(name + " ruszyła się ");
            super.move(savanna);
        }

        @Override
        public void eat(Savanna savanna) {
            System.out.print(name);
            super.eat(savanna);
        }

        @Override
        public String toString() {
            return "Giraffe- komórka: " +
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

        public boolean isEatGrass() {
            return eatGrass;
        }

        public void setEatGrass(boolean eatGrass) {
            this.eatGrass = eatGrass;
        }

        public boolean isEatTree() {
            return eatTree;
        }

        public void setEatTree(boolean eatTree) {
            this.eatTree = eatTree;
        }
    }
