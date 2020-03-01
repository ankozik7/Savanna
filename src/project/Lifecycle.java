package project;



import project.animals.Animal;

import java.util.Scanner;

public class Lifecycle {

    // Tworzenie sawanny
   // Savanna savanna = new Savanna(7, 7, 20, 15, 15, 7);


    //Tworzenie sawanny
    public Savanna createSavanna(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Podaj liczbę rzędów planszy");
        int rows= scanner.nextInt();
        System.out.println("Podaj liczbę kolumn planszy");
        int cols=scanner.nextInt();
        System.out.println("Podaj liczbę drzewy");
        int trees=scanner.nextInt();
        System.out.println("Podaj liczbę żyraf");
        int giraffes=scanner.nextInt();
        System.out.println("Podaj liczbę zeber");
        int zebras=scanner.nextInt();
        System.out.println("Podaj liczbę lwów");
        int lions=scanner.nextInt();
        Savanna savanna= new Savanna(rows,cols,trees,giraffes,zebras,lions);
        return savanna;

    }
    //
    public int daysCycle(){

        System.out.println("Podaj ilość dni cyklu trwania sawanny");
        Scanner scanner= new Scanner(System.in);
        int days= scanner.nextInt();
        return days;

    }
//Pętla cyklu na sawannie
    public void lifeCycle( ){
       Savanna savanna= createSavanna();
       int days=daysCycle();
        for (int i = 0; i < days; i++) {
        //Wzrost roślin
        savanna.oneDay();
        //Pozycja początkowa, ruch i jedzenie zwierząt
        for (Animal animal : savanna.getAnimals()) {
            animal.oneDay(savanna);
        }
        savanna.getAnimals().removeIf(animal -> savanna.getPreys().contains(animal));
        //Stan roślin i zwierząt w poszczególnych komórkach
        System.out.println("Podsumowanie stanu w komórkach");
        for (int k = 0; k < savanna.getRows(); k++) {
            for (int j = 0; j < savanna.getCols(); j++) {
                System.out.println("komórka " + k + ", " + j + ":");
                savanna.getConcreteCell(k, j).getPlant().show();
                System.out.println(savanna.getConcreteCell(k, j).toString());
            }
        }
        //Podsumowanie ilosci zwierząt na całej sawannie po danym dniu
        System.out.println("Na sawannie żyje " + savanna.getAnimals().size() + " zwierząt");
    }}

       /* Pozostałe metody mogące się do czegoś przydać

//Pozycja zwierząt

        for (Animal animal : savanna.getAnimals()) {
            animal.position();
        }

// zwierzęta jedzą
        for (Animal animal : savanna.getAnimals()) {
            animal.eat(savanna);
        }

//usuwanie zjedzonych zwierząt
        savanna.getAnimals().removeIf(animal -> savanna.getPreys().contains(animal));

// poruszanie się zwierząt
        for (Animal animal : savanna.getAnimals()) {
            animal.move(savanna);
        }

   */

}


