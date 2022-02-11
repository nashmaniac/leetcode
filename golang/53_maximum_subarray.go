package golang

type maximumSubarrayProblem struct {
}

func (m *maximumSubarrayProblem) Variation1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	result := make([]int, len(nums))
	result[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		result[i] = max(nums[i], result[i-1]+nums[i])
	}
	maxValue := 0
	for _, n := range result {
		maxValue = max(maxValue, n)
	}
	return maxValue
}

func (m *maximumSubarrayProblem) Variation2(nums []int) int {
	maxValue := 0
	if len(nums) == 0 {
		return 0
	}
	maxValue = nums[0]
	currentSumSoFar := nums[0]
	for i := 1; i < len(nums); i++ {
		currentSumSoFar = max(nums[i], currentSumSoFar+nums[i])
		maxValue = max(maxValue, currentSumSoFar)
	}
	return maxValue
}

func maxSubArray(nums []int) int {
	m := maximumSubarrayProblem{}
	return m.Variation2(nums)
}
