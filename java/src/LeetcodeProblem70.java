import java.util.Arrays;

/***
@author shetu2153@gmail.com
Problem: Climb Stairs
Leetcode Problem Number: 70
****/

public class LeetcodeProblem70 {
    int[] result;
    public int climbStairs(int n) {
        result = new int[n+1];
        Arrays.fill(result, -1);
        result[n] = climbStairsMemoized(n);
        for(int i: result) {
            System.out.printf("%d ", i);
        }
        return result[n];
    }
    public int climbStairsMemoized(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        if(result[n] != -1) {
            return result[n];
        } else {
            result[n-1] = climbStairsMemoized(n-1);
            result[n-2] = climbStairsMemoized(n-2);
            result[n] = result[n-1] + result[n-2];
            return result[n];
        }
    }

    public static void main(String[] args) {
        LeetcodeProblem70 l = new LeetcodeProblem70();
        System.out.print(l.climbStairs(4));
    }
}
