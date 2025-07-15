import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] games = new int[n];

        for (int i = 0; i < n; i++) {
            games[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] ps = new int[n + 1];
        ps[0] = 0;
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + games[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 建立 prefix sum 陣列需 O(n)。
 * 2. 輸出前 k 筆結果需 O(k)，最壞 O(n)。
 * 3. 總時間複雜度為 O(n)。
 */