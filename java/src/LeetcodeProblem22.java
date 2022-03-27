/***
@author shetu2153@gmail.com
Problem: Generate Parentheses Problem
Leetcode Problem Number: 22
****/

import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem22 {

    // Generate Parentheses problem
    private void generateString(List<String> result, int n, String s, int open, int closed) {
        if(s.length() == 2*n) {
            result.add(s);
            return;
        }

        if(open < n) {
            generateString(result, n, s+"(", open+1, closed);
        }
        if(closed < open) {
            generateString(result, n, s+")", open, closed+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateString(result, n, "", 0, 0);
        return result;        
    }

    public static void main(String[] args) {
        LeetcodeProblem22 l = new LeetcodeProblem22();
        List<String> result = l.generateParenthesis(3);
        for(String r: result) {
            System.out.println(r);
        }
    }
    
}
