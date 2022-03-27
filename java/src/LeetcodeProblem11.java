/***
@author shetu2153@gmail.com
Problem: Container with most water
Leetcode Problem Number: 11
****/

public class LeetcodeProblem11 {
    // Container with most water problem
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;
        while(start < end) {
            int currArea = (end-start) * Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, currArea);
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
    
}
