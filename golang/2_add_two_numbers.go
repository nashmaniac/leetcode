package golang

type addTwoNumberProblem struct {
}

func (a *addTwoNumberProblem) Variation1(l1 *ListNode, l2 *ListNode) *ListNode {
	// sentinel
	sentinel := &ListNode{Val: -1}
	dummy := sentinel

	carry := 0
	for l1 != nil && l2 != nil {
		sum := carry + l1.Val + l2.Val
		dummy.Next = &ListNode{Val: sum%10}
		dummy = dummy.Next
		carry = sum / 10
		l1 = l1.Next
		l2 = l2.Next
	}

	if l1 != nil {
		for l1 != nil {
			sum := carry + l1.Val
			dummy.Next = &ListNode{Val: sum%10}
			dummy = dummy.Next
			carry = sum / 10
			l1 = l1.Next
		}	
	}

	if l2 != nil {
		for l2 != nil {
			sum := carry + l2.Val
			dummy.Next = &ListNode{Val: sum%10}
			dummy = dummy.Next
			carry = sum / 10
			l2 = l2.Next
		}	
	}

	if carry > 0 {
		dummy.Next = &ListNode{Val: carry}
		dummy = dummy.Next
	}
	return sentinel.Next
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	a := addTwoNumberProblem{}
	return a.Variation1(l1, l2)
}
