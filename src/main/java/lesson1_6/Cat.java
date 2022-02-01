package lesson1_6;

public class Cat extends Animal {

    private final static int run = 200;
    private final static int swim = 0;
    private static int counter;

    public Cat(String name) {
        super(name, run, swim);
        counter++;
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать");
    }

    public static void total() {
        System.out.println("Объектов класса Cat создано: " + counter);
    }
}
