import java.util.ArrayList;
import java.util.List;

/***
@author shetu2153@gmail.com
Problem: FizzBuzz
Leetcode Problem Number: 412
****/

public class LeetcodeProblem412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for(int i=1;i<=n;i++) {
            if(i % 3 == 0) {
                String s = "Fizz";
                if(i % 5 == 0) {
                    s += "Buzz";
                }
                result.add(s);
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
