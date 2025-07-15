import java.util.Scanner;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 6;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(arr[i]);
            if (i != 6) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}