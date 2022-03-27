/***
@author shetu2153@gmail.com
Problem: Implement Trie
Leetcode Problem Number: 208
****/
class TrieNode {
    TrieNode[] children;
    boolean isEndWord;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEndWord = false;
    }
}

class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        word = word.toLowerCase();
        int level = word.length();
        TrieNode curNode = this.root;
        for(int i=0;i<level;i++) {
            int index = word.charAt(i) - 'a';
            if(curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];
        }
        curNode.isEndWord = true;
    }
    
    public boolean search(String word) {
        word = word.toLowerCase();
        int level = word.length();
        TrieNode curNode = this.root;
        for(int i=0;i<level;i++) {
            int index = word.charAt(i) - 'a';
            if(curNode.children[index] == null) {
                return false;
            }
            curNode = curNode.children[index];
        }
        return curNode.isEndWord;
    }
    
    public boolean startsWith(String prefix) {
        prefix = prefix.toLowerCase();
        int level = prefix.length();
        TrieNode curNode = this.root;
        for(int i=0;i<level;i++) {
            int index = prefix.charAt(i) - 'a';
            if(curNode.children[index] == null) {
                return false;
            }
            curNode = curNode.children[index];
        }
        return true;
    }
}

public class LeetcodeProblem208 {
    

    public static void main(String[] args) {
        Trie t = new Trie();
        String word = "hello";
        t.insert(word);
        boolean param_2 = t.search(word);
        boolean param_3 = t.startsWith("hell");
        System.out.println(param_2);
        System.out.println(param_3);
    }

}
