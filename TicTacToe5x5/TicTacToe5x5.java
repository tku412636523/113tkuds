import java.util.Scanner;

public class TicTacToe5x5 {
    public static final int SIZE = 5;
    public static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        while (true) {
            int row = -1, col = -1;
            boolean validMove = false;

            while (!validMove) {
                System.out.print("玩家 " + currentPlayer + " 請輸入 row col（0–4）：");
                if (sc.hasNextInt()) {
                    row = sc.nextInt();
                } else {
                    System.out.println("請輸入整數！");
                    sc.next(); // 清除錯誤輸入
                    continue;
                }

                if (sc.hasNextInt()) {
                    col = sc.nextInt();
                } else {
                    System.out.println("請輸入整數！");
                    sc.next(); // 清除錯誤輸入
                    continue;
                }

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
                    validMove = true;
                } else {
                    System.out.println("無效的輸入，請重新輸入合法且未被佔用的位置！");
                }
            }

            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            }

            if (isBoardFull()) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        sc.close();
    }

    public static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    public static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '.';
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }

    public static boolean checkWin(char player) {
        // 檢查每一行
        for (int i = 0; i < SIZE; i++) {
            boolean rowWin = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        // 檢查每一列
        for (int j = 0; j < SIZE; j++) {
            boolean colWin = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        // 檢查主對角線
        boolean diag1Win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                diag1Win = false;
                break;
            }
        }
        if (diag1Win) return true;

        // 檢查反對角線
        boolean diag2Win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                diag2Win = false;
                break;
            }
        }
        if (diag2Win) return true;

        return false;
    }
}