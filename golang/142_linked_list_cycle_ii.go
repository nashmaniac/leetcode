package golang

type linkedListCycleProblemII struct {
}

func (l *linkedListCycleProblemII) Variation1(head *ListNode) *ListNode {
	// declare hashmap
	var hashmap map[*ListNode]bool = make(map[*ListNode]bool)
	current := head
	for current != nil {
		if _, ok := hashmap[current]; !ok {
			hashmap[current] = true
		} else {
			return current
		}
		current = current.Next
	}
	return nil
}

func (l *linkedListCycleProblemII) Variation2(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	slowPointer := head
	fastPointer := head

	for fastPointer != nil && fastPointer.Next != nil {
		slowPointer = slowPointer.Next
		fastPointer = fastPointer.Next.Next
		if fastPointer == slowPointer {
			seeker := head
			for seeker != slowPointer {
				slowPointer = slowPointer.Next
				seeker = seeker.Next
			}
			return seeker
		}
	}
	return nil
}

func detectCycle(head *ListNode) *ListNode {
	l := linkedListCycleProblemII{}
	return l.Variation1(head)
}
