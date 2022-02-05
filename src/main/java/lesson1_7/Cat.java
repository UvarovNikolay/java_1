package lesson1_7;

public class Cat {

    private String name;
    private boolean satiety;
    private final static int appetite = 20;

    public Cat(String name) {
        this.name = name;
        this.satiety = false;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            this.satiety = true;
        } else {
            System.out.println("В тарелке не хватает еды");
        }
    }
}
