package lesson1_6;

public abstract class Animal {

    protected String name;
    protected int run;
    protected int swim;
    protected int length;
    private static int counter;

    public Animal (String name, int run, int swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        counter++;
    }

    public void run(int length) {
        if (0 < length && length <= run) {
            System.out.println(name + " пробежал " + length + " метров");
        } else {
            System.out.println(name + " не может столько пробежать");
        }
    }

    public void swim(int length) {
        if (0 < length && length <= run) {
            System.out.println(name + " проплыл " + length + " метров");
        } else {
            System.out.println(name + " не может столько проплыть");
        }
    }

    public static void total() {
        System.out.println("Объектов класса Animal создано: " + counter);
    }
}
