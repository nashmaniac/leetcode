class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        total = int(len(nums)*(len(nums)+1)/2)
        for i in nums:
            total -= i
        return total