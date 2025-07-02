public class array_sum_trace {
    public static void main(String[] args) {
        int[] ar = {1, 3, 5};
        int total = 0;

        for (int i = 0; i < ar.length; i++) {
            int oldTotal = total;
            total += ar[i];
            System.out.println("加總過程：total=" + oldTotal + "+" + ar[i] + "=" + total);
        }

        System.out.println("總和為：" + total);
    }
}
