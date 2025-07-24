public class printReverse {  

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void printReverse(ListNode head) {
        if (head == null) {
            return;  
        }

        printReverse(head.next);
        
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.print("Reverse list: ");
        printReverse(head);  
    }
}
