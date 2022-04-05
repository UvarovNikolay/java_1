package lesson2_1;

public class Wall extends Barrier{
    private int height;

    public Wall(String name, int height) {
        super(name);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean moving(Actions actions) {
        System.out.println("The wall " + super.getName() + " height: " + height);
        actions.jump();
        if (getHeight() <= actions.getJumpHeight()) {
            System.out.println("jump ok");
            return true;
        } else {
            System.out.println("jump not ok");
            return false;
        }
    }
}