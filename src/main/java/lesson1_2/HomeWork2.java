package lesson1_2;

public class HomeWork2 {

    public static void main(String[] args) {

        int firstNumber = getRandom(40) - 20;
        int secondNumber = getRandom(20);
        int year = getRandom(3000);

        boolean resultSumTwoNumbers = sumTwoNumbers(firstNumber, secondNumber);
        System.out.println(resultSumTwoNumbers);

        boolean resultNumberCheck = numberCheck(firstNumber);
        System.out.println(resultNumberCheck);

        String str = generateString(secondNumber);
        printString(str, secondNumber);

        boolean resultYearCheck = yearCheck(year);
        System.out.println(resultYearCheck);

    }

    public static boolean sumTwoNumbers(int n1, int n2) {
        if (10 <= (n1 + n2) && (n1 + n2) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberCheck (int n) {
        if (n >= 0) {
            System.out.println("Число положительное");
            return false;
        } else {
            System.out.println("Число отрицательное");
            return true;
        }
    }

    public static void printString (String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static boolean yearCheck (int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

    public static int getRandom (int max) {

        return (int) Math.round(Math.random() * max);

    }

    public  static String generateString (int length) {

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String generateStr = new String();

        for (int i = 0; i < length; i++) {
            Character chr = letters.charAt(getRandom(letters.length() - 1));
            generateStr += chr;
        }
        return generateStr;
    }
}