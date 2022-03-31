package lesson2_1;

import java.util.Random;

public class HomeWork1 {

    public static void main(String[] args) {

        Random random = new Random();
        Actions[] actions = new Actions[3];
        Barrier[] barriers = new Barrier[10];

        actions[0] = new Human("Ivan", random.nextInt(10), random.nextInt(100));
        actions[1] = new Cat("Boris", random.nextInt(10), random.nextInt(100));
        actions[2] = new Robot("Bender", random.nextInt(10), random.nextInt(100));

        for (int i = 0; i < barriers.length; i++) {
            if (i % 2 == 0) {
                barriers[i] = new Treadmill("Treadmill" + (i + 1), random.nextInt(10));
            } else {
                barriers[i] = new Wall("Wall" + (i + 1), random.nextInt(100));
            }
        }

        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < barriers.length; j++) {
                result = barriers[j].moving(actions[i]);
                if (!result) {
                    break;
                }
            }
            if (result) {
                System.out.println("Success!");
            } else {
                System.out.println("unsuccessfully!");
            }
        }
    }
}