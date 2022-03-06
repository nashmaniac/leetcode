package golang

import "log"

type LongestPalindromicSubsequenceProblem struct {
}

func maxValue(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func (l *LongestPalindromicSubsequenceProblem) longestPalindromicSubsequenceRecursive(
	s string,
	start int,
	end int,
) int {
	// basis case
	if start > end {
		return 0
	}
	if start == end {
		return 1
	}
	if s[start] == s[end] {
		return 2 + l.longestPalindromicSubsequenceRecursive(s, start+1, end-1)
	}

	c1 := l.longestPalindromicSubsequenceRecursive(s, start, end-1)
	c2 := l.longestPalindromicSubsequenceRecursive(s, start+1, end)
	return maxValue(c1, c2)
}

func (l *LongestPalindromicSubsequenceProblem) longestPalindromicSubsequenceTopDown(
	result [][]*int,
	s string,
	start int,
	end int,
) int {
	if start > end {
		return 0
	}
	if start == end {
		return 1
	}

	if result[start][end] == nil {
		var r int
		if s[start] == s[end] {
			r = 2
			r = r + l.longestPalindromicSubsequenceRecursive(s, start+1, end-1)
		} else {
			c1 := l.longestPalindromicSubsequenceRecursive(s, start, end-1)
			c2 := l.longestPalindromicSubsequenceRecursive(s, start+1, end)
			r = maxValue(c1, c2)
		}

		result[start][end] = &r
	}

	return *result[start][end]
}

func (l *LongestPalindromicSubsequenceProblem) longestPalindromicSubsequenceBottomUp(s string) int {
	result := make([][]int, len(s))
	for i, _ := range s {
		result[i] = make([]int, len(s))
	}

	for i, _ := range result {
		result[i][i] = 1
	}

	for i := len(result) - 1; i >= 0; i-- {
		for j := i + 1; j < len(result); j++ {
			if s[i] == s[j] {
				result[i][j] = 2 + result[i+1][j-1]
			} else {
				result[i][j] = maxValue(result[i+1][j], result[i][j-1])
			}
		}
	}
	return result[0][len(s)-1]
}

func longestPalindromeSubseq(s string) int {
	l := LongestPalindromicSubsequenceProblem{}
	return l.longestPalindromicSubsequenceBottomUp(s)
}

func LongestPalindromeSubseq(s string) int {
	log.Println(s)
	return longestPalindromeSubseq(s)
}
