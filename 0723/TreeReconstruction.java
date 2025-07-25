import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 根據前序 + 中序 重建樹
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = inMap.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize,
                               in, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd,
                                in, inRoot + 1, inEnd, inMap);

        return root;
    }

    // 2. 根據後序 + 中序 重建樹
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(post[postEnd]);
        int inRoot = inMap.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1,
                                in, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1,
                                 in, inRoot + 1, inEnd, inMap);

        return root;
    }

    // 3. 驗證：中序走訪
    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    // 前序走訪
    public static void printPreorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public static void main(String[] args) {
        // 範例：
        //        3
        //       / \
        //      9  20
        //         / \
        //        15  7

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode rootFromPre = buildTreeFromPreIn(preorder, inorder);
        TreeNode rootFromPost = buildTreeFromPostIn(postorder, inorder);

        System.out.println("用前序+中序建立的樹（中序遍歷）：");
        printInorder(rootFromPre); // 預期輸出：9 3 15 20 7
        System.out.println();

        System.out.println("用後序+中序建立的樹（前序遍歷）：");
        printPreorder(rootFromPost); // 預期輸出：3 9 20 15 7
        System.out.println();
    }
}
