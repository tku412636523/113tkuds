public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class Imbalance {
        TreeNode node = null;
        int maxDiff = -1;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        Imbalance result = new Imbalance();
        dfs(root, result);
        return result.node;
    }

    private static void dfs(TreeNode node, Imbalance result) {
        if (node == null) return;

        int balance = Math.abs(getBalanceFactor(node));
        if (balance > result.maxDiff) {
            result.maxDiff = balance;
            result.node = node;
        }

        dfs(node.left, result);
        dfs(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);  
        root.right = new TreeNode(15);

        System.out.println("是否為平衡樹？ " + isBalanced(root)); 

        System.out.println("根節點的平衡因子： " + getBalanceFactor(root)); 

        TreeNode unbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點值為： " + unbalanced.val);
        System.out.println("其平衡因子為： " + getBalanceFactor(unbalanced));
    }
}
