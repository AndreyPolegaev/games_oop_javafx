package ru.job4j.puzzle;
/*
добавить еще 2 дополнительных метода, которые будут
проверять строку и столбец на нашем игровом поле, которые мы будем вызывать в методе check() при определенных условиях.
 */
public class Win {
    public static boolean check(int[][] board) {
        return (checkVertical(board) || checkHorizontal(board));
    }
    public static boolean checkVertical(int[][] board) {
        boolean rsl = false;
        boolean[] step = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            boolean condition = false;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 1) {
                    condition = true;
                    break;
                }
            }
            if (!condition) {
                step[i] = true;
            }
        }
        for (boolean temp : step) {
            if (temp == true) {
                rsl = true;
            }
        }
        return rsl;
    }

    public static boolean checkHorizontal(int[][] board) {
        boolean rsl = false;
        boolean[] step = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            boolean condition = false;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 1) {
                    condition = true;
                    break;
                }
            }
            if (!condition) {
                step[i] = true;
            }
        }
        for (boolean temp : step) {
            if (temp == true) {
                rsl = true;
            }
        }
        return rsl;
    }
}
