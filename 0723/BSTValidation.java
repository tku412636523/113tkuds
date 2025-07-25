import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;

        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();
        findInvalidHelper(root, inorder);

        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                if (!invalid.contains(inorder.get(i - 1))) {
                    invalid.add(inorder.get(i - 1));
                }
                invalid.add(inorder.get(i));
            }
        }

        return invalid;
    }

    private static void findInvalidHelper(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        findInvalidHelper(node.left, inorder);
        inorder.add(node.val);
        findInvalidHelper(node.right, inorder);
    }

    public static int countNodesToRemove(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        findInvalidHelper(root, inorder);
        int n = inorder.size();

        List<Integer> lis = new ArrayList<>();
        for (int val : inorder) {
            int pos = Collections.binarySearch(lis, val);
            if (pos < 0) pos = -pos - 1;
            if (pos == lis.size()) {
                lis.add(val);
            } else {
                lis.set(pos, val);
            }
        }
        return n - lis.size(); 
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);  
        root.right.right = new TreeNode(20);

        System.out.println("是否為有效BST：" + isValidBST(root));
        System.out.println("不合法的節點：" + findInvalidNodes(root));
        System.out.println("需要移除的節點數：" + countNodesToRemove(root));
    }
}
