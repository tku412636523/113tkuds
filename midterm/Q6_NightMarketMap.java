import java.util.Scanner;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] map = new char[10][10];

        // 初始化地圖為 #
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = '#';
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 列印地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}