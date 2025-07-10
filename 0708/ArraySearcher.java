public class ArraySearcher {
    public static void main(String[] args) {
        int[] array = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 測試搜尋 67
        int target1 = 67;
        int index1 = findElement(array, target1);
        int count1 = countOccurrences(array, target1);
        System.out.println("搜尋數字 " + target1 + "：索引 = " + index1 + "，出現次數 = " + count1);

        // 測試搜尋 100
        int target2 = 100;
        int index2 = findElement(array, target2);
        int count2 = countOccurrences(array, target2);
        System.out.println("搜尋數字 " + target2 + "：索引 = " + index2 + "，出現次數 = " + count2);
    }

    /** * 搜尋指定元素，回傳索引；若找不到，回傳 -1
     */
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 計算指定元素在陣列中出現的次數
     */
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
