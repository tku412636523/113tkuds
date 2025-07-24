public class inOrder {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void s(TreeNode root) {
        if (root == null) {
            return;  
        }
        
        s(root.left);
        
        System.out.print(root.val + " ");
        
        s(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.print("In-order Traversal: ");
        s(root);  
    }
}
