package golang

func twoSum(nums []int, target int) []int {
	var hashmap map[int]int = make(map[int]int)
	for i := 0; i < len(nums); i++ {
		diff := target - nums[i]
		if found, ok := hashmap[nums[i]]; !ok {
			hashmap[diff] = i
		} else {
			return []int{found, i}
		}
	}

	return []int{-1, -1}
}
