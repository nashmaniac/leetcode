import java.util.Arrays;

/***
@author shetu2153@gmail.com
Problem: Nth - Tribonacci Number
Leetcode Problem Number: 1137
****/

public class LeetcodeProblem1137 {

    int[] result;

    public int tribonacci1(int n) {
        result = new int[n+1];
        Arrays.fill(result, -1);
        result[n] = tribonacciMemoized(n);
        return result[n];
    }

    public int tribonacciMemoized(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        if(result[n] != -1) {
            return result[n];
        } else {
            result[n-1] = tribonacciMemoized(n-1);
            result[n-2] = tribonacciMemoized(n-2);
            result[n-3] = tribonacciMemoized(n-3);
            return result[n-1] + result[n-2] + result[n-3];
        }
    }

    public int tribonacci(int n) {
        int[] result = new int[n+1];
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        result[0] = tribonacci(0);
        result[1] = tribonacci(1);
        result[2] = tribonacci(2);
        for(int i=3;i<=n;i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result[n];
        
    }

    public static void main(String[] args) {
        LeetcodeProblem1137 l = new LeetcodeProblem1137();
        System.out.println(l.tribonacci(4));
        System.out.println(l.tribonacci(25));
    }
}
