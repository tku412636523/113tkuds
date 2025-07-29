import java.util.*;

public class F10_BSTRangeSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static int rangeSum(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R); // 剪掉左邊
        if (root.val > R) return rangeSum(root.left, L, R);  // 剪掉右邊
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        int L = sc.nextInt(), R = sc.nextInt();
        TreeNode root = null;
        for (String s : values) {
            int val = Integer.parseInt(s);
            root = insert(root, val);
        }
        System.out.println("Sum: " + rangeSum(root, L, R));
    }
}

