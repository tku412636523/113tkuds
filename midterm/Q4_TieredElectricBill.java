import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int total = 0;

        int[] bills = new int[n];

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            bills[i] = bill;
            total += bill;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Bill: $" + bills[i]);
        }

        int avg = (int) Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    // 計算分段電價
    private static int calc(int kWh) {
        double cost = 0;

        if (kWh > 1000) {
            cost += (kWh - 1000) * 8.46;
            kWh = 1000;
        }
        if (kWh > 700) {
            cost += (kWh - 700) * 6.24;
            kWh = 700;
        }
        if (kWh > 500) {
            cost += (kWh - 500) * 5.04;
            kWh = 500;
        }
        if (kWh > 330) {
            cost += (kWh - 330) * 3.70;
            kWh = 330;
        }
        if (kWh > 120) {
            cost += (kWh - 120) * 2.45;
            kWh = 120;
        }
        if (kWh > 0) {
            cost += kWh * 1.68;
        }

        return (int) Math.round(cost);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 對每筆電量計算分段金額，單次 O(1)。
 * 2. 共需處理 n 筆數據，總複雜度 O(n)。
 */