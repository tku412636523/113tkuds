import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
            taxes[i] = calculateTax(incomes[i]);
            totalTax += taxes[i];
        }

        for (int tax : taxes) {
            System.out.println("Tax: $" + tax);
        }

        int avg = totalTax / n;
        System.out.println("Average: $" + avg);
        sc.close();
    }

    public static int calculateTax(int income) {
        int tax = 0;

        int[] brackets = { 0, 560000, 1260000, 2520000, 4720000 };
        double[] rates = { 0.05, 0.12, 0.20, 0.30, 0.40 };

        int[] limits = { 560000, 700000, 1260000, 2200000 }; 

        int remaining = income;

        for (int i = 0; i < limits.length; i++) {
            if (remaining <= limits[i]) {
                tax += (int)(remaining * rates[i]);
                return tax;
            } else {
                tax += (int)(limits[i] * rates[i]);
                remaining -= limits[i];
            }
        }

        tax += (int)(remaining * rates[4]);
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每一筆收入稅金計算都是固定區間比較與加總，時間為常數；總共 n 筆收入，總時間複雜度為 O(n)。
 */
