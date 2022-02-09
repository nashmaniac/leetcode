package golang

type nodeWithLevel struct {
	Node  *TreeNode
	Level int
}

func levelOrder(root *TreeNode) [][]int {
	var arr [][]int = make([][]int, 0)
	if root == nil {
		return arr
	}
	queue := make([]nodeWithLevel, 0)
	queue = append(queue, nodeWithLevel{
		Node:  root,
		Level: 1,
	})

	for len(queue) > 0 {
		currentNode := queue[0]
		if len(arr) != currentNode.Level {
			arr = append(arr, []int{})
		}
		arr[currentNode.Level-1] = append(arr[currentNode.Level-1], currentNode.Node.Val)
		if currentNode.Node.Left != nil {
			queue = append(queue, nodeWithLevel{
				Node:  currentNode.Node.Left,
				Level: currentNode.Level + 1,
			})
		}
		if currentNode.Node.Right != nil {
			queue = append(queue, nodeWithLevel{
				Node:  currentNode.Node.Right,
				Level: currentNode.Level + 1,
			})
		}

		queue = queue[1:]
	}
	return arr
}
