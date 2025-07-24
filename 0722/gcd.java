public class gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;  
        }
        return gcd(b, a % b);  
    }

    public static void main(String[] args) {
        int a = 56;
        int b = 98;
        int result = gcd(a, b);  
        System.out.println("The gcd of " + a + " and " + b + " is: " + result);
    }
}
