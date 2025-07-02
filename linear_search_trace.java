import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < s.length; i++) {
            System.out.println("比對中：" + key + " vs " + s[i]);
            if (s[i] == key) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("結果：找到");
        } else {
            System.out.println("結果：未找到");
        }

        sc.close();
    }
}