package lesson2_1;

public abstract class Barrier {
    private String name;

    public Barrier(String name) {
        this.name = name;
    }

    public abstract boolean moving(Actions actions);

    public String getName() {
        return name;
    }
}