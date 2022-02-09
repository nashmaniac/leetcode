package golang

import "math"

func isValid(root *TreeNode, minValue int, maxValue int) bool {
	if root == nil {
		return true
	}

	if root.Val <= minValue || root.Val >= maxValue {
		return false
	}

	return isValid(root.Left, minValue, root.Val) && isValid(root.Right, root.Val, maxValue)
}

func isValidBST(root *TreeNode) bool {
	return isValid(root, math.MinInt64, math.MaxInt64)
}
