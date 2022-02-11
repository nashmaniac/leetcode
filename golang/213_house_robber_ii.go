package golang

type houseRobberProblemII struct {
}

func robHouse(nums []int) []int {
	result := make([]int, len(nums)+1)
	result[0] = 0
	result[1] = nums[0]

	for i := 2; i < len(result); i++ {
		result[i] = max(result[i-1], result[i-2]+nums[i-1])
	}
	return result
}

func (h *houseRobberProblemII) Variation1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}
	
	withFirstHouse := robHouse(nums[:len(nums)-1])
	withoutFirstHouse := robHouse(nums[1:])

	return max(withFirstHouse[len(withFirstHouse)-1], withoutFirstHouse[len(withoutFirstHouse)-1])
}

func robII(nums []int) int {
	h := houseRobberProblemII{}
	return h.Variation1(nums)
}
