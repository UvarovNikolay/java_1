package lesson1_6;

public class Dog extends Animal {

    private final static int run = 500;
    private final static int swim = 10;
    private static int counter;

    public Dog(String name) {
        super(name, run, swim);
        counter++;
    }

    public static void total() {
        System.out.println("Объектов класса Dog создано: " + counter);
    }
}
