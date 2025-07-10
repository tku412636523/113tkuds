public class BasicArrayOperations {
    public static void main(String[] args) {
        // 宣告陣列並初始化
        int[] arr = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 輸出陣列長度
        System.out.println("陣列長度：" + arr.length);

        // 修改第 3 個位置 (索引 2) 為 99
        arr[2] = 99;

        // 修改最後一個位置為 100
        arr[arr.length - 1] = 100;

        // 使用傳統 for 迴圈輸出所有元素
        for (int i = 0; i < arr.length; i++) {
            System.out.println("索引：" + i + " 值：" + arr[i]);
        }
    }
}
