package golang

type subarraySumProblem struct {
}

func (s *subarraySumProblem) Variation1(nums []int, k int) int {
	count := 0
	for i := 0; i < len(nums); i++ {
		runningSum := 0
		for j := i; j < len(nums); j++ {
			if runningSum+nums[j] == k {
				count += 1
			}
			runningSum += nums[j]
		}
	}
	return count
}

func subarraySum(nums []int, k int) int {
	s := subarraySumProblem{}
	return s.Variation1(nums, k)
}
