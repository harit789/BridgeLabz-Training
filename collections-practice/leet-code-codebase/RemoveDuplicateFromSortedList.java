import RemoveDuplicateFromSortedList.ListNode;

public class RemoveDuplicateFromSortedList {

	 public class ListNode {
	     int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode temp = head;
	        while(temp.next != null){
	            if(temp.val  == temp.next.val && temp.next.next != null){
	                temp.next = temp.next.next;
	            } else if(temp.next.next == null){
	                if(temp.val == temp.next.val){
	                    temp.next = null;
	                } else {
	                    temp = temp.next;
	                }
	            } else {
	                temp = temp.next;
	            }
	        }
	        return head;
	    }
	}
}
