/***
@author shetu2153@gmail.com
Problem: Fibonacci Number
Leetcode Problem Number: 509
****/

public class LeetcodeProblem509 {
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int[] result = new int[n+1];
        result[0] = fib(0);
        result[1] = fib(1);
        for(int i=2;i<=n;i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
