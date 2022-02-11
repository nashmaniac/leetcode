package golang

type coinChangeProblem struct {
}

func (c *coinChangeProblem) Variation1(coins []int, amount int) int {
	// first build the array to store result
	result := make([]int, amount+1)
	for i := 0; i < amount+1; i++ {
		result[i] = amount + 1
	}
	result[0] = 0

	for i := 1; i < amount+1; i++ {
		for j := 0; j < len(coins); j++ {
			if i >= coins[j] {
				result[i] = minValue(result[i], 1+result[i-coins[j]])
			}
		}
	}

	if result[amount] == amount+1 {
		return -1
	}
	return result[amount]
}

func minValue(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func coinChange(coins []int, amount int) int {
	c := coinChangeProblem{}
	return c.Variation1(coins, amount)
}
