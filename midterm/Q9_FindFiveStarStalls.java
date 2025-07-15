import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        // 先計算 5.0 的數量
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5.0) {
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println("None");
        } else {
            int[] idx = new int[cnt];
            int pos = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5.0) {
                    idx[pos++] = i;
                }
            }
            for (int i = 0; i < cnt; i++) {
                System.out.print(idx[i]);
                if (i != cnt - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}