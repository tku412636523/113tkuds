import java.util.Scanner;

public class F06_ArraySecondLargest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    static class Pair {
        int max;
        int second;
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    // 遞迴找最大與次大
    static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair leftPair = findSecondMax(arr, left, mid);
        Pair rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;

        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(rightPair.max, leftPair.second);
        } else {
            max = rightPair.max;
            second = Math.max(leftPair.max, rightPair.second);
        }

        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：此遞迴演算法為分治法，將陣列一分為二，每層合併操作僅比較固定次數（最多 4 次），
 * 整體遞迴深度為 O(log n)，每層處理所有 n 個元素，因此總時間複雜度為 O(n)。
 */
