package golang

type removeDuplicatesFromSortedListProblemII struct {
}

func (r *removeDuplicatesFromSortedListProblemII) Variation1(head *ListNode) *ListNode {

	// declare the sentinel nodes
	sentinel := &ListNode{Val: -1}
	sentinel.Next = head
	pred := sentinel
	for head != nil {
		if head.Next != nil && head.Val == head.Next.Val {
			for head.Next != nil && head.Val == head.Next.Val {
				head = head.Next
			}
			pred.Next = head.Next
		} else {
			pred = pred.Next
		}
		head = head.Next
	}
	return sentinel.Next
}

func deleteDuplicatesII(head *ListNode) *ListNode {
	r := removeDuplicatesFromSortedListProblemII{}
	return r.Variation1(head)
}
