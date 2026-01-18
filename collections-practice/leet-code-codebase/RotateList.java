

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ||head.next == null ||  k == 0){
            return head;
        }
            ListNode lastNode = head;
            int size = 1;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
                size++;
            }
            lastNode.next = head;
            k = k % size;
            ListNode newNode = head;
            for(int i = 1; i < size - k; i++){
                newNode = newNode.next;
            }
            ListNode newHead = newNode.next;
            newNode.next = null;
            return newHead;
    }
}