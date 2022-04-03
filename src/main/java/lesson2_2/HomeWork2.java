package lesson2_2;

import java.util.Random;
import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of array rows: ");
        int x = scanner.nextInt();
        System.out.print("Enter the number of array columns: ");
        int y = scanner.nextInt();

        String[][] stringArray = new String[x][y];
        checkArraySize(stringArray);
        fillArray(stringArray);
        int sumElementsArrayResult = sumArrayElements(stringArray);
        System.out.println("The sum of the array elements is: " + sumElementsArrayResult);

    }

    public static void fillArray(String[][] array) {

        Random random = new Random();
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Character.toString(symbols.charAt(random.nextInt(35)));
            }
        }
    }

    public static void checkArraySize(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
    }

    public static int sumArrayElements(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }
}