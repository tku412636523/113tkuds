import java.util.Arrays;

public class ArrayUtility {
    public static void main(String[] args) {
        int[] array = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.println("原始陣列：");
        printArray(array);

        // 測試 reverseArray
        reverseArray(array);
        System.out.println("反轉後的陣列：");
        printArray(array);

        // 測試 copyArray
        int[] copiedArray = copyArray(array);
        System.out.println("複製的陣列：");
        printArray(copiedArray);

        // 測試 findSecondLargest
        int secondLargest = findSecondLargest(array);
        System.out.println("陣列中的第二大值：" + secondLargest);
    }

    /**
     * 列印陣列內容，格式 [元素1, 元素2, ...]
     */
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 原地反轉陣列
     */
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 建立陣列的副本
     */
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    /**
     * 找出陣列中的第二大值
     */
    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("陣列長度必須至少為 2。");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("陣列中沒有第二大的不同值。");
        }

        return second;
    }
}
