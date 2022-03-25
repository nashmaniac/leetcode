public class LeetcodeProblem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode falseHead = dummy;
        ListNode curr = dummy;
        for(int i=0;i<=n && curr != null;i++) {
            curr = curr.next;
        }

        while(curr != null) {
            dummy = dummy.next;
            curr = curr.next;
        }

        if(dummy.next != null) {
            dummy.next = dummy.next.next;
        }
        return falseHead.next;
    }
}
