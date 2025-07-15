import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        // 選擇排序 (由高到低)
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 交換
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        // 輸出前 5 名（或全部）
        int limit = Math.min(5, n);
        for (int i = 0; i < limit; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：
 * 1. 外層跑 n 次，內層最多 n-1 次比較。
 * 2. 每次找最大並交換，總比較次數約為 n(n-1)/2。
 * 3. 因此時間複雜度為 O(n^2)。
 */