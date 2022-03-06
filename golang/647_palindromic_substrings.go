package golang

type countSubstringProblem struct {
}

func (c *countSubstringProblem) IsPalindrome(s string, start int, end int) int {

	var count int = 0

	for start < end && start >= 0 && end < len(s) {
		if s[start] != s[end] {
			break
		}
		count++
		start--
		end++
	}

	return count
}

func (c *countSubstringProblem) countSubstrings(s string) int {
	count := len(s)

	for i := 0; i < len(s); i++ {
		count += c.IsPalindrome(s, i-1, i+1)
		count += c.IsPalindrome(s, i, i+1)
	}

	return count
}

func countSubstrings(s string) int {
	c := countSubstringProblem{}
	return c.countSubstrings(s)
}

func CountSubstrings(s string) int {
	return countSubstrings(s)
}
