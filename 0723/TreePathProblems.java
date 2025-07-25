import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 所有根到葉的路徑
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsAllPaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfsAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path)); // 是葉節點
        } else {
            dfsAllPaths(node.left, path, result);
            dfsAllPaths(node.right, path, result);
        }

        path.remove(path.size() - 1); // 回溯
    }

    // 2. 是否存在和為 targetSum 的根到葉路徑
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 葉節點
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }

    // 3. 找出和最大的根到葉路徑
    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxSumPathHelper(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void maxSumPathHelper(TreeNode node, List<Integer> path, int currentSum, int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        path.add(node.val);
        currentSum += node.val;

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            maxSumPathHelper(node.left, path, currentSum, maxSum, maxPath);
            maxSumPathHelper(node.right, path, currentSum, maxSum, maxPath);
        }

        path.remove(path.size() - 1); // 回溯
    }

    public static void main(String[] args) {
        /*
                範例樹：
                    5
                   / \
                  4   8
                 /   / \
                11  13  4
               /  \      \
              7    2      1
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("所有根到葉路徑：");
        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int target = 22;
        System.out.println("是否存在和為 " + target + " 的路徑：" + hasPathSum(root, target));

        System.out.println("和最大的根到葉路徑：" + maxSumPath(root));
    }
}
