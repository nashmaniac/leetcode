import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem131 {

    public boolean isPalindrome(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public void recursivePalindrome(int index, String s, List<String> tempResult, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(tempResult));
        }

        for(int i=index;i<s.length();i++) {
            tempResult.add(s.substring(index, i+1));

            if(isPalindrome(s, index, i)) {
                recursivePalindrome(i+1, s, tempResult, result);
            }
            tempResult.remove(tempResult.size()-1);
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        recursivePalindrome(0, s, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem131 l = new LeetcodeProblem131();

        System.out.println(l.partition("aab").toString());
    }
}
