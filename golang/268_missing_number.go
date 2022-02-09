package golang

func missingNumber(nums []int) int {
	total := 0
	for _, num := range nums {
		total += num
	}

	n := len(nums)
	return ((n * (n + 1)) / 2) - total
}
