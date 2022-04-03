package lesson2_1;

public class Treadmill extends Barrier {
    private int distance;

    public Treadmill(String name, int distance) {
        super(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public boolean moving(Actions actions) {
        System.out.println("The treadmill " + super.getName() + " distance: " + distance);
        actions.run();
        if (getDistance() <= actions.getRunDistance()) {
            System.out.println("run ok");
            return true;
        } else {
            System.out.println("run not ok");
            return false;
        }
    }
}