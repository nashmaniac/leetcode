package golang

type removeDuplicatesFromSortedListProblem struct {
}

func (r *removeDuplicatesFromSortedListProblem) Variation1(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	current := head
	for current != nil && current.Next != nil {
		for current.Next != nil && current.Val == current.Next.Val {
			current.Next = current.Next.Next
		}
		current = current.Next
	}
	return head
}

func deleteDuplicates(head *ListNode) *ListNode {
	r := removeDuplicatesFromSortedListProblem{}
	return r.Variation1(head)
}
