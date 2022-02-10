class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closingList = [')', '}', ']']
        startList = ['(', '{', '[']
        characterMap = {
            ')': '(',
            '}': '{',
            ']': '[',
        }
        
        for ch in s:
            if ch in closingList:
                if len(stack) == 0 or stack[-1] != characterMap[ch]:
                    return False
                stack.pop()
            if ch in startList:
                stack.append(ch)
                
        return len(stack) == 0