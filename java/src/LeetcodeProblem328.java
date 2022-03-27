/***
@author shetu2153@gmail.com
Problem: Odd Even Linked List
Leetcode Problem Number: 328
****/

public class LeetcodeProblem328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode oddHead = oddDummy;
        ListNode evenHead = evenDummy;

        while(head != null) {
            oddHead.next = head;
            evenHead.next = head.next;

            oddHead = oddHead.next;
            evenHead = evenHead.next;

            if(head.next != null) {
                head = head.next.next;
            } else {
                head = head.next;
            }
        }

        if(oddHead!=null) {
            oddHead.next = evenDummy.next;
        }

        return oddDummy.next;

    }
}
