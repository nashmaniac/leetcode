/***
@author shetu2153@gmail.com
Problem: Middle of the Linked List
Leetcode Problem Number: 876
****/

public class LeetcodeProblem876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
