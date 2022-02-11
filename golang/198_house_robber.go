package golang

type houseRobberProblem struct {
}

func (h *houseRobberProblem) Variation1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}

	result := make([]int, len(nums)+1)
	result[0] = 0
	result[1] = nums[0]

	for i := 2; i < len(result); i++ {
		result[i] = max(result[i-1], result[i-2]+nums[i-1])
	}

	return result[len(nums)]
}

func rob(nums []int) int {
	h := houseRobberProblem{}
	return h.Variation1(nums)
}
