package golang

func copyRandomList(head *Node) *Node {
	var hashmap map[*Node]*Node = make(map[*Node]*Node)

	var nodeList []*Node = make([]*Node, 0)

	for current := head; current != nil; {
		// make new node.
		node := &Node{Val: current.Val}
		nodeList = append(nodeList, node)
		hashmap[current] = node
		current = current.Next
	}

	for i, current := 0, head; current != nil; {
		if i != 0 {
			nodeList[i-1].Next = nodeList[i]
		}
		nodeList[i].Random = hashmap[current.Random]
		current = current.Next
		i++
	}

	return nodeList[0]
}
