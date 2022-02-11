package golang

import "math"

type bestTimeToSellStockProblem struct {
}

func (b *bestTimeToSellStockProblem) Variation1(prices []int) int {
	maxValue := 0
	minValueSoFar := math.MaxInt32

	for i := 0; i < len(prices); i++ {
		maxValue = max(maxValue, prices[i]-minValueSoFar)
		minValueSoFar = min(prices[i], minValueSoFar)
	}
	return maxValue
}

func maxProfit(prices []int) int {
	b := bestTimeToSellStockProblem{}
	return b.Variation1(prices)
}
