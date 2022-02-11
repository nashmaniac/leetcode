package golang

type bestTimeToSellStockProblemII struct {
}

func (b *bestTimeToSellStockProblemII) Variation1(prices []int) int {
	sum := 0
	for i := 1; i < len(prices); i++ {
		sum += max(0, prices[i]-prices[i-1])
	}
	return sum
}

func maxProfitII(prices []int) int {
	b := bestTimeToSellStockProblemII{}
	return b.Variation1(prices)
}
