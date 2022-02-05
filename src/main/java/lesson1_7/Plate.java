package lesson1_7;

public class Plate {

    private int food;

    public Plate(int food) {
        if (food >= 0) {
            this.food = food;
        } else {
            System.out.println("Количество еды в тарелке не может быть отрицательным");
        }
    }

    public void setFood(int food) {
        if (food > 0) {
            this.food = food;
        } else {
            System.out.println("Нельзя добавить в тарелку количество еды меньше 1");
        }
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int food) {
        this.food -= food;
    }
}
