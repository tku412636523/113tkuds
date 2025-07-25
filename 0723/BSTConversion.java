public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int val) {
            this.val = val;
        }
    }

    static DoublyListNode head = null, prev = null;

    public static DoublyListNode bstToDoublyList(TreeNode root) {
        inorderToList(root);
        return head;
    }

    private static void inorderToList(TreeNode node) {
        if (node == null) return;

        inorderToList(node.left);

        DoublyListNode curr = new DoublyListNode(node.val);
        if (prev == null) {
            head = curr;
        } else {
            prev.next = curr;
            curr.prev = prev;
        }
        prev = curr;

        inorderToList(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] arr) {
        return buildBST(arr, 0, arr.length - 1);
    }

    private static TreeNode buildBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);
        return root;
    }

    static int sum = 0;

    public static void convertBSTToGreaterTree(TreeNode root) {
        if (root == null) return;

        convertBSTToGreaterTree(root.right);
        sum += root.val;
        root.val = sum;
        convertBSTToGreaterTree(root.left);
    }

    public static void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }

    public static void printDoublyList(DoublyListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(4);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(5);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(3);

        System.out.print("BST -> 雙向鏈表：");
        DoublyListNode list = bstToDoublyList(bst);
        printDoublyList(list); 

        int[] sortedArr = {-10, -3, 0, 5, 9};
        TreeNode balancedBST = sortedArrayToBST(sortedArr);
        System.out.print("平衡 BST：");
        printInorder(balancedBST); 
        System.out.println();

        TreeNode testTree = new TreeNode(5);
        testTree.left = new TreeNode(2);
        testTree.right = new TreeNode(13);
        convertBSTToGreaterTree(testTree);
        System.out.print("Greater Tree：");
        printInorder(testTree); 
    }
}
