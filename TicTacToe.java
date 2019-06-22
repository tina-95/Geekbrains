import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /*
    Блок настроек игры
     */

    private static char[][] map; // матрица игры
    private static int SIZE = 3; // размерность полей

    private static final char DOT_EMPTY = '•'; //пустое место
    private static final char DOT_X = 'X'; //крестик
    private static final char DOT_O = 'O'; //нолик

    private static final boolean SILLY_MODE = true;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    static int[][] compSteps = new int[SIZE * 2 + 1][SIZE];

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {

            humanTurn(); //ход игрока
            if (isEndGame(DOT_X)) {
                break;
            }


            computerTurn(); //ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра закончена");

        /**
         Метод подготовки игрового поля
         */
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод вывода игрового поля на экран
     */

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * ход человека
     */

    private static void humanTurn() {

        int x, y;

        do {
            System.out.println("Введите значение координат через пробел:");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;

    }

    /**
     * Ход компьютера
     */
    private static void computerTurn() {

        int x=-1 ;
        int y=-1 ;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);

            } while (!isCellValid(x, y));
        } else if (tryWin(DOT_O)) {

            return;
        }


        System.out.println("Компьютер выбрал ячейку: " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

    }


    /**
     * Метод валидации запрашиваемой ячейки на корректность
     *
     * @param x -координаты по горизонтали
     * @param y - координаты по вертикали
     * @return boolean - признак валидности
     */

    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        //проверка координаты
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }

        //проверка заполненности ячейки
        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }
        return result;

    }

    /**
     * Метод проверки игры на завершение
     *
     * @param symbol - символ, которым играет текущий игрок
     * @return boolean признак завершеня игры
     */
    private static boolean isEndGame(char symbol) {
        boolean result = false;
        printMap();

        // проверяем необходимость следующего хода
        if (checkWin(DOT_X)) {
            System.out.println("Победили " + symbol);
            result = true;
        } else if (checkWin(DOT_O)) {
            System.out.println("Победили " + DOT_O);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }
        return result;

    }

    /**
     * Проверка на 100%-ю заполненность поля
     *
     * @return boolean признак оптимальности
     */

    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }

    /**
     * Метод проверки выигрыша
     *
     * @param symbol символ, введенный пользователем
     * @return boolean - результат проверки
     */

    public static Boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int horizont = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symbol) horizont++;
                if (horizont == SIZE-1) return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            int vertical = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symbol) vertical++;
                if (vertical == SIZE-1) return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            int diagVersa = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) diagVersa++;
                i++;
                if (diagVersa == SIZE-1) return true;
            }
        }
        for (int i = map.length - 1; i > 0; i--) {
            int diagStretch = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symbol) diagStretch++;
                i--;
                if (diagStretch == SIZE-1) return true;
            }
        }
        return false;
    }

    public static boolean tryWin(char ch) {
        for (int i = 0; i < SIZE; i++) {
            if (tryHorizont(i, ch)) {
                return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (tryVertical(i, ch)) {
                return true;
            }
        }
        if (tryDiagStretch(ch)) {
            return true;
        }
        if (tryDiagVersa(ch)) {
            return true;
        }
        return false;
    }

    public static boolean tryHorizont(int row, char ch) {
        int res = 0;
        int emptyI = 0;
        int emptyJ = 0;
        for (int j = 0; j < SIZE; j++) {
            if (map[row][j] == DOT_EMPTY) {
                emptyI = row;
                emptyJ = j;
            }
        }
        return TrySetResult(res, emptyI, emptyJ);
    }

    public static boolean tryDiagStretch(char ch) {
        int res = 0;
        int emptyI = 0;
        int emptyJ = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == ch) {
                res++;
            } else if (map[i][i] == DOT_EMPTY) {
                emptyI = emptyJ = i;
            }

        }

        return TrySetResult(res, emptyI, emptyJ);
    }

    public static boolean tryDiagVersa(char ch) {
        int res = 0;
        int emptyI = 0;
        int emptyJ = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][3- i - 1] == ch) {
                res++;
            } else if (map[i][3 - i - 1] == DOT_EMPTY) {
                emptyI = i;
                emptyJ = 3 - i - 1;
            }

        }

        return TrySetResult(res, emptyI, emptyJ);
    }

    public static boolean tryVertical(int col, char ch) {
        int res = 0;
        int emptyI = 0;
        int emptyJ = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][col] == DOT_EMPTY) {
                emptyI = i;
                emptyJ = col;
            }
        }
        return TrySetResult(res, emptyI, emptyJ);
    }

    public static boolean TrySetResult(int res, int emptyI, int emptyJ) {
        if (res == 2 && emptyI != -1 && emptyJ != -1) {
            map[emptyI][emptyJ] = DOT_O;
            return true;
        } else {
            return false;
        }
    }
}
