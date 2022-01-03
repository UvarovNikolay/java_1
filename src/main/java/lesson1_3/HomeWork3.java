package lesson1_3;

import lesson1_2.HomeWork2;

import java.util.Arrays;

public class HomeWork3 {

    public static void main(String[] args) {

        int[] arrayZerosOnes = new int[10];
        fillArrayRandomNumbers(arrayZerosOnes, 1);
        System.out.println(Arrays.toString(arrayZerosOnes));
        invertArray(arrayZerosOnes);
        System.out.println(Arrays.toString(arrayZerosOnes));

        int[] arrayOneHundredNumbers = new int[100];
        fillArray(arrayOneHundredNumbers);
        System.out.println(Arrays.toString(arrayOneHundredNumbers));

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array3));

        int[][] squareArray = new int[5][5];
        printTwoDimensionalArray(squareArray);
        fillDiagonalsArray(squareArray);
        System.out.println();
        printTwoDimensionalArray(squareArray);
        System.out.println();

        int[] array5 = generateArray(2, 5);
        System.out.println(Arrays.toString(array5));

        int[] resultFindMinMaxNumberArray = findMinMaxNumberArray(array3);
        System.out.println(resultFindMinMaxNumberArray[0]);
        System.out.println(resultFindMinMaxNumberArray[1]);

        boolean resultCheckBalanceArray = checkBalanceArray(array3);
        System.out.println(resultCheckBalanceArray);

        System.out.println(Arrays.toString(array3));
        moveNumbersArray(array3, -11);
        System.out.println(Arrays.toString(array3));
        moveNumbersArray(array3, 2);
        System.out.println(Arrays.toString(array3));

    }

    public static void fillArrayRandomNumbers(int[] array, int max) {
        HomeWork2 hw2 = new HomeWork2();
        for (int i = 0; i < array.length; i++) {
            array[i] = hw2.getRandom(max);
        }
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void printTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void fillDiagonalsArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {        //не использую "array[i].length" т.к. массив по условию квадратный.
                if (i == j || i == (array.length - (j + 1))) {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static int[] generateArray(int initialValue, int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static int[] findMinMaxNumberArray(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            } else if (max < array[i]) {
                max = array[i];
            }
        }
        return new int[]{min, max};
    }

    public static boolean checkBalanceArray(int[] array) {
        boolean result = false;
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            left += array[i];
            int right = 0;
            for (int j = i + 1; j < array.length; j++) {
                right += array[j];
            }
            if (left == right) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void moveNumbersArray(int[] array, int n) {
        int helpInt = 0;
        for (int i = 0; i < (Math.abs(n) % array.length); i++) {
            if (n > 0) {
                for (int j = array.length - 1; j > 0; j--) {
                    if (j == array.length - 1) {
                        helpInt = array[j];
                    }
                    array[j] = array[j - 1];
                }
                array[0] = helpInt;
            }
            if (n < 0) {
                for (int k = 0; k < array.length - 1; k++) {
                    if (k == 0) {
                        helpInt = array[k];
                    }
                    array[k] = array[k + 1];
                }
                array[array.length - 1] = helpInt;
            }
        }
    }
}