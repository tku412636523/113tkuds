public class ArrayStatistics {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = calculateSum(arr);
        double average = (double) sum / arr.length;
        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;
        int countAboveAvg = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < arr.length; i++) {
            // 最大、最小
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
            // 大於平均值
            if (arr[i] > average) {
                countAboveAvg++;
            }

            // 奇偶數計數
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 表格輸出
        System.out.println("====== 陣列統計分析 ======");
        System.out.printf("%-15s %s\n", "統計項目", "結果");
        System.out.println("-------------------------------");
        System.out.printf("%-15s %d\n", "總和", sum);
        System.out.printf("%-15s %.2f\n", "平均值", average);
        System.out.printf("%-15s %d (索引 %d)\n", "最大值", max, maxIndex);
        System.out.printf("%-15s %d (索引 %d)\n", "最小值", min, minIndex);
        System.out.printf("%-15s %d\n", "大於平均值數", countAboveAvg);
        System.out.printf("%-15s %d\n", "偶數個數", evenCount);
        System.out.printf("%-15s %d\n", "奇數個數", oddCount);
    }

    /**
     * 計算陣列總和
     */
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}