public class GradeProcessor {
    public static void main(String[] args) {
        // 建立成績陣列
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        int sum = 0;
        double average;
        int max = grades[0];
        int min = grades[0];
        int maxIndex = 0;
        int minIndex = 0;

        // 計算總分、最高分、最低分
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];

            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }

            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }
       average = (double) sum / grades.length;

        // 計算成績高於平均的人數
        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }

        // 輸出結果
        System.out.println("總分：" + sum);
        System.out.printf("平均分數：%.2f\n", average);
        System.out.println("最高分：" + max + " (索引：" + maxIndex + ")");
        System.out.println("最低分：" + min + " (索引：" + minIndex + ")");
        System.out.println("高於平均分的人數：" + countAboveAverage);
        System.out.println("所有成績：");

        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號：" + i + " 成績：" + grades[i]);
        }
    }
}
