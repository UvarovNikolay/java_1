package lesson2_1;

public class Robot implements Actions {
    private String name;
    private int jumpHeight;
    private int runDistance;

    public Robot(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public void jump() {
        System.out.println("Robot " + name + " jump " + jumpHeight);
    }

    @Override
    public void run() {
        System.out.println("Robot " + name + " run " + runDistance);
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