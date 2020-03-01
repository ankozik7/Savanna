package project.animals;


import project.Savanna;

public interface Animal {


        int getRow();

        void setRow(int row);

        int getCol();

        void setCol(int col);

        void eat(Savanna savanna);

        void move(Savanna savanna);

        void position();

        void oneDay(Savanna savanna);

    }


