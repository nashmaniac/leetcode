import java.util.List;

public class LeetcodeProblem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumNode = new ListNode(-1);
        ListNode curr = dumNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            while (list1 != null) {
                curr.next = list1;
                list1 = list1.next;

                curr = curr.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }

        return dumNode.next;
    }

}