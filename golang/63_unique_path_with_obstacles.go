package golang

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])

	result := make([][]int, m)

	for i := 0; i < m; i++ {
		result[i] = make([]int, n)
		for j := 0; j < n; j++ {
			result[i][j] = 0
		}
	}
	for i := 0; i < m; i++ {
		if obstacleGrid[i][0] != 1 {
			result[i][0] = 1
		}

	}
	for i := 0; i < n; i++ {
		if obstacleGrid[0][i] != 1 {
			result[0][i] = 1
		}
	}

	if result[0][0] == 0 {
		return 0
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				result[i][j] = 0
				continue
			}
			result[i][j] += (result[i][j-1] + result[i-1][j])
		}
	}

	return result[m-1][n-1]
}
