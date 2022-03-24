public class LeetcodeProblem557 {

    public void reverseString(char[] s, int left, int right) {
        while (left <= right) {
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                reverseString(arr, left, i-1);
                left = i+1;
            }
        }
        reverseString(arr, left, arr.length-1);
        return new String(arr);
    }

}
