package golang

type longestSubstringWithoutRepeatProblem struct {
}

func (l *longestSubstringWithoutRepeatProblem) Variation1(s string) int {
	maxLength := 0
	startIndex := 0
	var hashmap map[byte]int = make(map[byte]int)

	for i := 0; i < len(s); i++ {
		if lastIndex, ok := hashmap[s[i]]; ok {
			startIndex = max(startIndex, lastIndex+1)
		}
		currentLength := i - startIndex + 1
		maxLength = max(currentLength, maxLength)
		hashmap[s[i]] = i
	}
	return maxLength
}

func lengthOfLongestSubstring(s string) int {
	l := longestSubstringWithoutRepeatProblem{}
	return l.Variation1(s)
}
