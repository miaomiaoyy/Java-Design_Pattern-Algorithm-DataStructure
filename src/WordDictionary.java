public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for(char c : arr) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
        }
        cur.isEnd = true;
    }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int start, TrieNode node) {
        if(start == word.length()) return node.isEnd;
        char[] arr = word.toCharArray();
        char c = arr[start];
        if(c == '.') {
            for(int i = 0 ; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if(helper(word, start + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // if(node.children[c - 'a'] == null) return false;
            // node = node.children[c - 'a'];//node = a
            // return helper(word, start + 1, node);
            return node.children[c - 'a'] != null && helper(word, start + 1, node.children[c - 'a']);
        }
    }





    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("abc");
        System.out.print(wd.search(".bc"));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

