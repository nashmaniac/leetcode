package golang

type intersectionOfTwoArrayProblem struct {
}

func (i *intersectionOfTwoArrayProblem) Variation1(nums1 []int, nums2 []int) []int {
	result := make([]int, 0)
	firstMap := make(map[int]bool)
	secondMap := make(map[int]bool)
	for i := 0; i < len(nums1); i++ {
		firstMap[nums1[i]] = true
	}

	for i := 0; i < len(nums2); i++ {
		if _, ok := firstMap[nums2[i]]; ok {
			if _, secondOk := secondMap[nums2[i]]; !secondOk {
				result = append(result, nums2[i])
			}
			secondMap[nums2[i]] = true
		}
	}
	return result
}

func intersection(nums1 []int, nums2 []int) []int {
	i := intersectionOfTwoArrayProblem{}
	return i.Variation1(nums1, nums2)
}
