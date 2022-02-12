package golang

type firstUniqueCharacterProblem struct {
}

func (f *firstUniqueCharacterProblem) Variation1(s string) int {
	hashmap := make(map[rune]int)

	for _, ch := range s {
		if found, ok := hashmap[ch]; !ok {
			hashmap[ch] = 1
		} else {
			hashmap[ch] = 1 + found
		}
	}

	for i, ch := range s {
		if found, ok := hashmap[ch]; ok {
			if found == 1 {
				return i
			}
		}
	}
	return -1
}

func firstUniqChar(s string) int {
	f := firstUniqueCharacterProblem{}
	return f.Variation1(s)
}
