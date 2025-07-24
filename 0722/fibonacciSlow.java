public class fibonacciSlow {

    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
    
    public static void main(String[] args) {
        int n = 40;  

        long startSlow = System.currentTimeMillis();
        int resultSlow = fibonacciSlow(n);
        long endSlow = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + resultSlow);
        System.out.println("Time (slow): " + (endSlow - startSlow) + " ms");

        
        int[] memo = new int[n + 1];  // 初始值為 0
        long startFast = System.currentTimeMillis();
        int resultFast = fibonacciFast(n, memo);
        long endFast = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + resultFast);
        System.out.println("Time (fast): " + (endFast - startFast) + " ms");
    }
}
