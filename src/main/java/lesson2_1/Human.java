package lesson2_1;

public class Human implements Actions {
    private String name;
    private int jumpHeight;
    private int runDistance;

    public Human(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public void jump() {
        System.out.println("Human " + name + " jump " + jumpHeight);
    }

    @Override
    public void run() {
        System.out.println("Human " + name + " run " + runDistance);
    }

    @Override
    public int getJumpHeight() {
        return this.jumpHeight;
    }

    @Override
    public int getRunDistance() {
        return this.runDistance;
    }
}