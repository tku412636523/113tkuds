import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            times[i] = hour * 60 + minute;
        }

        String[] queryParts = sc.nextLine().split(":");
        int queryTime = Integer.parseInt(queryParts[0]) * 60 + Integer.parseInt(queryParts[1]);

        int left = 0, right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                result = times[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (result == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", result / 60, result % 60);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋尋找大於查詢時間的最早時間，時間為 O(log n)
 */
