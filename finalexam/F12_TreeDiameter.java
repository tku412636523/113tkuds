import java.util.*;

public class F12_TreeDiameter {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int diameter = 0;

    static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);
        height(root);
        System.out.println("Diameter: " + diameter);
    }

    static TreeNode buildTree(String[] tokens) {
        if (tokens[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode curr = queue.poll();
            if (!tokens[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(curr.left);
            }
            i++;
            if (i < tokens.length && !tokens[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

