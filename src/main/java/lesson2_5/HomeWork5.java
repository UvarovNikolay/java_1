package lesson2_5;

import java.util.Arrays;

public class HomeWork5 {

    static final int SIZE = 10000000;

    public static void main(String[] args) {

        float[] firstArray = new float[SIZE];
        float[] secondArray = new float[SIZE];

        firstMethod(firstArray);
        secondMethod(secondArray);
    }

    private static void firstMethod(float[] array) {

        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = formula(array[i], i);
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static void secondMethod(float[] array) {

        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[SIZE/2];
        float[] rightHalf = new float[SIZE/2];

        System.arraycopy(array, 0, leftHalf, 0, SIZE/2);
        System.arraycopy(array, SIZE/2, rightHalf, 0, SIZE/2);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = formula(leftHalf[i], i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = formula(rightHalf[i], i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(rightHalf, 0, array, 0, SIZE/2);
        System.arraycopy(leftHalf, 0, array, SIZE/2, SIZE/2);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static float formula(float value, int index) {
        return (float) (value * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
    }
}