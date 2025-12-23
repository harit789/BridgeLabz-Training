class Solution {
    public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        if (size == 1) {
            return null;
        } else if (n == size) {
            head = head.next;
        } else {
            for (int i = 1; i < size - n; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;

    }

}