package golang

type linkedListCycleProblem struct {
}

func (l *linkedListCycleProblem) Variation1(head *ListNode) bool {
	// declare hashmap
	var hashmap map[*ListNode]bool = make(map[*ListNode]bool)
	current := head
	for current != nil {
		if _, ok := hashmap[current]; !ok {
			hashmap[current] = true
		} else {
			return true
		}
		current = current.Next
	}
	return false
}

func (l *linkedListCycleProblem) Variation2(head *ListNode) bool {
	if head == nil {
		return false
	}
	slowPointer := head
	fastPointer := head.Next

	for slowPointer != fastPointer {
		if fastPointer == nil || fastPointer.Next == nil {
			return false
		}
		slowPointer = slowPointer.Next
		fastPointer = fastPointer.Next.Next
	}
	return true
}

func hasCycle(head *ListNode) bool {
	l := linkedListCycleProblem{}
	return l.Variation1(head)
}
