import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        int d1 = getDepth(lca, val1, 0);
        int d2 = getDepth(lca, val2, 0);
        return d1 + d2;
    }

    private static TreeNode findLCA(TreeNode node, int val1, int val2) {
        if (node == null) return null;
        if (node.val == val1 || node.val == val2) return node;

        TreeNode left = findLCA(node.left, val1, val2);
        TreeNode right = findLCA(node.right, val1, val2);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    private static int getDepth(TreeNode node, int val, int depth) {
        if (node == null) return -1;
        if (node.val == val) return depth;

        int left = getDepth(node.left, val, depth + 1);
        if (left != -1) return left;

        return getDepth(node.right, val, depth + 1);
    }

    static int maxDiameter = 0;

    public static int diameter(TreeNode root) {
        maxDiameter = 0;
        getHeight(root);
        return maxDiameter;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static List<Integer> nodesAtDistance(TreeNode root, int targetDistance) {
        List<Integer> result = new ArrayList<>();
        dfsDistance(root, 0, targetDistance, result);
        return result;
    }

    private static void dfsDistance(TreeNode node, int depth, int target, List<Integer> result) {
        if (node == null) return;
        if (depth == target) result.add(node.val);
        dfsDistance(node.left, depth + 1, target, result);
        dfsDistance(node.right, depth + 1, target, result);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("節點 4 和 5 的距離: " + distanceBetweenNodes(root, 4, 5)); // 2
        System.out.println("節點 4 和 6 的距離: " + distanceBetweenNodes(root, 4, 6)); // 4

        System.out.println("樹的直徑: " + diameter(root)); 
        List<Integer> level2 = nodesAtDistance(root, 2);
        System.out.println("距離根節點為 2 的節點: " + level2); 
    }
}
