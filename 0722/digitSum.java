public class digitSum {
    public static int digitSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + digitSum(n / 10);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("The sum of digits of " + n + " is: " + digitSum(n));  // 結果應該是 15
    }
}
