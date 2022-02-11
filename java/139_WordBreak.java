import java.util.List;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        for(int i=0;i<s.length()+1;i++) {
            arr[i] = false;
        }
        arr[0] = true;

        for (int i=0;i<s.length()+1;i++) {
            for(int j=0;j<i;j++) {
                String o = s.substring(j, i);
                if(arr[j] && wordDict.contains(o)) {
                    arr[i] = true;
                    break;
                }
            }
        }

        return arr[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");

        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak(s, wordDict));
    }
}