package lesson2_2;

public class MyArraySizeException extends IndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Array size is not 4x4");
    }
}
