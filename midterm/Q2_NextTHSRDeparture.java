import java.util.*;

public class Q2_NextTHSRDeparture {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] rawTimes = new String[n];

        for (int i = 0; i < n; i++) {
            rawTimes[i] = sc.nextLine();
            times[i] = toMinutes(rawTimes[i]);
        }

        String queryStr = sc.nextLine();
        int queryMin = toMinutes(queryStr);

        // Binary search for first time > query
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMin) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No train");
        } else {
            System.out.println(rawTimes[ans]);
        }
    }

    // 將 HH:mm 轉成 總分鐘數
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * 1. 將時間轉換為分鐘為 O(n)。
 * 2. 使用二分搜尋找第一個大於 query 的時間為 O(log n)。
 * 3. 總時間複雜度為 O(log n)。
 */