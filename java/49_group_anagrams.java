import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> arr = new ArrayList<>();

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String m = new String(c);
            if (hashMap.containsKey(m)) {
                ArrayList<String> a = hashMap.get(m);
                a.add(s);
                hashMap.put(m,a);
            } else {
                hashMap.put(m, new ArrayList<>(List.of(s)));
            }
        }

        for(ArrayList<String> v: hashMap.values()) {
            arr.add(v);
        }
        return arr;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        g.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }
}