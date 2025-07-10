public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        char[] grades = new char[scores.length];
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int sum = 0;
        double average;

        int maxScore = scores[0];
        int minScore = scores[0];
        int maxIndex = 0;
        int minIndex = 0;

        // 計算總和、最高分、最低分
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];

            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }

            if (scores[i] < minScore) {
                minScore = scores[i];
                minIndex = i;
            }
        }

        average = (double) sum / scores.length;

        int countAboveAverage = 0;

        // 判斷等級與計數
        for (int i = 0; i < scores.length; i++) {
            grades[i] = getGrade(scores[i]);

            switch (grades[i]) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }

            if (scores[i] > average) {
                countAboveAverage++;
            }
        }

        double aboveAvgPercentage = (double) countAboveAverage / scores.length * 100;

        // 輸出成績報告
        printReport(scores, grades, average, countA, countB, countC, countD, maxScore, maxIndex, minScore, minIndex, aboveAvgPercentage);
    }

    /**
     * 根據分數回傳等級
     */
    public static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }

    /**
     * 列印完整報告
     */
    public static void printReport(int[] scores, char[] grades, double average,
                                   int countA, int countB, int countC, int countD,
                                   int maxScore, int maxIndex, int minScore, int minIndex,
                                   double aboveAvgPercentage) {
        System.out.println("======== 學生成績報告 ========");
        System.out.printf("全班平均分數：%.2f\n", average);
        System.out.println("-----------------------------");
        System.out.println("等級統計：");
        System.out.println("A 等：" + countA + " 人");
        System.out.println("B 等：" + countB + " 人");
        System.out.println("C 等：" + countC + " 人");
        System.out.println("D 等：" + countD + " 人");
        System.out.println("-----------------------------");
        System.out.println("最高分：" + maxScore + " (學生編號：" + maxIndex + ")");
        System.out.println("最低分：" + minScore + " (學生編號：" + minIndex + ")");
        System.out.printf("高於平均分的學生比例：%.2f%%\n", aboveAvgPercentage);
        System.out.println("-----------------------------");
        System.out.println("詳細成績列表：");
        System.out.printf("%-10s %-10s %-10s\n", "學生編號", "分數", "等級");
        System.out.println("---------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10c\n", i, scores[i], grades[i]);
        }
        System.out.println("===============================");
    }
}

