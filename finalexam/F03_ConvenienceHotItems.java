import java.util.Scanner;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            qtys[i] = sc.nextInt();
        }

        // 插入排序 - 依照 qtys 由高到低排序
        for (int i = 1; i < n; i++) {
            int keyQty = qtys[i];
            String keyName = names[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < keyQty) {
                qtys[j + 1] = qtys[j];
                names[j + 1] = names[j];
                j--;
            }
            qtys[j + 1] = keyQty;
            names[j + 1] = keyName;
        }

        // 輸出前10名
        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序，最壞情況需比較與移動 n*(n-1)/2 次，因此時間複雜度為 O(n²)。
 */
