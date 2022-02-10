package golang

type reverseLinkedListProblem struct {
}

func (r *reverseLinkedListProblem) Variation1(head *ListNode) *ListNode {
	var prev *ListNode = nil
	for head != nil {
		temp := head.Next
		head.Next = prev
		prev = head
		head = temp
	}
	return prev
}

func reverseList(head *ListNode) *ListNode {
	r := reverseLinkedListProblem{}
	return r.Variation1(head)
}
