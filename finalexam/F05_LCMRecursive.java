import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lcm = a * b / gcd(a, b);
        System.out.println("LCM: " + lcm);
        sc.close();
    }

    // 使用輾轉相減法的遞迴 GCD
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法每次遞迴最多減 1，最壞情況下要呼叫 max(a, b) 次，所以時間複雜度為 O(max(a, b))。
 * 若改用輾轉相除法（歐幾里得演算法），則時間可優化為 O(log(min(a, b)))。
 */
