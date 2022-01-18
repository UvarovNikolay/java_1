package lesson1_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CrossesZeroesApp {

    //Поле
    public static char[][] map;

    //Размер поля
    public static final int SIZE = 5;

    //Точек для победы
    public static final int DOTS_TO_WIN = 4;

    //Описание точек
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    //Сканер
    public static final Scanner SCANNER = new Scanner(System.in);

    //рандом
    public static final Random RANDOM = new Random();

    /**
     * Проинициализировать поле.
     */
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    /**
     * Вывод игрового поля на экран.
     */
    public static void printMap() {
        //нумеруем верхний ряд
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        //пишем строки мапы
        for (int i = 0; i < map.length; i++) {
            //выводим номер строки
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Ход человека.
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Ход робота.
     */
    public static void aiTurn() {
        if (!turnAnalysis(DOT_0, DOT_0)) {
            if (!turnAnalysis(DOT_X, DOT_0)) {
                aiRandomTurn();
            }
        }
    }

    /**
     * Анализ хода.
     * @param firstSymbol Символ, которым анализируется ход.
     * @param secondSymbol Символ, который записывается в игровое поле.
     * @return true, если найдена выигрышная комбинация, и сделан ход.
     */
    public static boolean turnAnalysis(char firstSymbol, char secondSymbol) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!isCellValid(i, j)) continue;
                map[j][i] = firstSymbol;
                if (checkWin(firstSymbol)) {
                    System.out.println("Робот делает ход в " + (i + 1) + " " + (j + 1));
                    map[j][i] = secondSymbol;
                    return true;
                } else {
                    map[j][i] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    /**
     * Рандомный ход робота.
     */
    public static void aiRandomTurn() {
        int x,y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Робот делает ход в " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }

    /**
     * Проверка, вылидны ли значения поля
     * @param x координата x
     * @param y координата y
     * @return да/нет
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    /**
     * Проверка победы.
     * @param symbol Символ для которого проверяем. Крестик или нолик
     * @return true, если выйграл
     */
    public static boolean checkWin(char symbol) {
        for (int y = 0; y <= (map.length - DOTS_TO_WIN); y++) {
            for (int x = 0; x <= (map[y].length - DOTS_TO_WIN); x++) {
                if (checkLines(symbol, x, y) || checkDiagonals(symbol, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка строк и колонок игрового поля.
     * @param symbol Символ для которого проверяем. Крестик или нолик
     * @param offsetX Смещение по оси X
     * @param offsetY Смещение по оси Y
     * @return true, если найдена строка/колонка, состоящая из символов "symbol", длинной DOTS_TO_WIN
     */
    public static boolean checkLines(char symbol, int offsetX, int offsetY) {
        boolean checkColumn;
        boolean checkRow;
        for (int y = offsetY; y < (DOTS_TO_WIN + offsetY); y++) {
            checkColumn = true;
            checkRow = true;
            for (int x = offsetX; x < (DOTS_TO_WIN + offsetX); x++) {
                checkColumn &= (map[x][y] == symbol);
                checkRow &= (map[y][x] == symbol);
            }
            if (checkColumn || checkRow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка диагоналей игрового поля.
     * @param symbol Символ для которого проверяем. Крестик или нолик
     * @param offsetX Смещение по оси X
     * @param offsetY Смещение по оси Y
     * @return true, если найдена диагональ, состоящая из символов "symbol", длинной DOTS_TO_WIN
     */
    public static boolean checkDiagonals(char symbol, int offsetX, int offsetY) {
        boolean checkMainDiagonal = true;
        boolean checkSecondaryDiagonal = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            checkMainDiagonal &= (map[i + offsetX][i + offsetY] == symbol);
            checkSecondaryDiagonal &= (map[DOTS_TO_WIN - i - 1 + offsetX][i + offsetY] == symbol);
        }
        if (checkMainDiagonal || checkSecondaryDiagonal) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверка, что в поле не осталось ни одной свободной ячейки.
     * @return true, нет ни одной свободной
     */
    public static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
           humanTurn();
           printMap();
           if(checkWin(DOT_X)) {
               System.out.println("Побеждает человек");
               break;
           }
           if (isMapFull()) {
               System.out.println("Ничья!");
               break;
           }
           aiTurn();
           printMap();
           if (checkWin(DOT_0)) {
               System.out.println("Побеждает компьютер");
               break;
           }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Game over");
    }
}
