public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }

    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (isIdentical(t1, t2)) return true;

        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    public static TreeNode largestCommonSubtree(TreeNode t1, TreeNode t2) {
        Result res = new Result();
        findCommon(t1, t2, res);
        return res.node;
    }

    static class Result {
        TreeNode node = null;
        int size = 0;  
    }

    private static int findCommon(TreeNode t1, TreeNode t2, Result res) {
        if (t1 == null || t2 == null) return 0;

        if (t1.val == t2.val && isIdentical(t1, t2)) {
            int sz = countNodes(t1);
            if (sz > res.size) {
                res.size = sz;
                res.node = t1;
            }
        }

        findCommon(t1.left, t2, res);
        findCommon(t1.right, t2, res);
        findCommon(t1, t2.left, res);
        findCommon(t1, t2.right, res);

        return res.size;
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        B.right = new TreeNode(2);

        System.out.println("A 和 B 完全相同？ " + isIdentical(A, B)); 

        System.out.println("B 是 A 的子樹？ " + isSubtree(A, B)); 

        TreeNode common = largestCommonSubtree(A, B);
        System.out.print("中序：");
        printInorder(common); 
        System.out.println();
    }
}
