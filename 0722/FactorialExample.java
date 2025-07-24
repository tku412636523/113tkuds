public class FactorialExample {

    public static void printFactorial(int n) {
        System.out.print(n + "! = ");
        
        int result = 1;
        
        // 特別處理 0!
        if (n == 0) {
            System.out.print("1 = 1");
            System.out.println();
            return;
        }

        // 印出乘法過程
        for (int i = n; i >= 1; i--) {
            System.out.print(i);
            if (i != 1) {
                System.out.print(" * ");
            }
            result *= i;
        }

        // 印出結果
        System.out.print(" = " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        printFactorial(3);  // 3! = 3 * 2 * 1 = 6
        printFactorial(5);  // 5! = 5 * 4 * 3 * 2 * 1 = 120
        printFactorial(0);  // 0! = 1 = 1
    }
}
