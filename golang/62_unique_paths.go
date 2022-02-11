package golang

func uniquePaths(m int, n int) int {
	result := make([][]int, m)

	for i := 0; i < m; i++ {
		result[i] = make([]int, n)
		for j := 0; j < n; j++ {
			result[i][j] = 0
		}
	}
	for i := 0; i < m; i++ {
		result[i][0] = 1
	}
	for i := 0; i < n; i++ {
		result[0][i] = 1
	}
	result[0][0] = 1

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			result[i][j] += (result[i][j-1] + result[i-1][j])
		}
	}

	return result[m-1][n-1]
}

func UniquePaths(m, n int) int {
	return uniquePaths(m, n)
}
