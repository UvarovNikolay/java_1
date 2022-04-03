package lesson2_2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int x, int y) {
        super("Failed to convert element (" + x + "," + y + ") of array to number");
    }
}
