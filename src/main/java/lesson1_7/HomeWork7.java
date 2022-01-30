package lesson1_7;

public class HomeWork7 {

    public static void main(String[] args) {

        Cat[] cats = new Cat[5];
        Plate plate = new Plate(60);

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот" + (i + 1));
        }

        for (Cat cat:cats) {
            cat.eat(plate);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " " + cats[i].getSatiety());
        }

    }
}
