package lesson1_6;

public class HomeWork6 {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Бобик");

        cat1.run(10);
        cat1.swim(10);

        dog1.run(200);
        dog1.swim(5);

        Animal.total();
        Cat.total();
        Dog.total();
    }
}
