import java.util.ArrayList;
import java.util.List;

class MagicDictionary {

//method 1: use HashSet

     // class MagicDictionary {
//     HashSet<String> set;
//     public MagicDictionary() {
//         set = new HashSet<>();
//     }
//     public void buildDict(String[] dict) {
//        for(String s : dict) {
//            set.add(s);
//        }
//     }
//     public boolean search(String word) {
//         char[] str = word.toCharArray();
//         for(int i = 0; i < str.length; i++) {
//             char org = str[i];
//             for(char c = 'a'; c <= 'z'; c++) {
//                 if(org != c) {
//                     str[i] = c;
//                     if(set.contains(new String (str))) {  //str.toString() 就不对？？？？
//                         return true;
//                     }
//                 }
//             }
//             str[i] = org;
//         }
//         return false;
//     }
// }

   //method 2 use list
//     List<String> list;
//     /** Initialize your data structure here. */
//     public MagicDictionary() {
//         list = new ArrayList<>();
//     }
//
//     /** Build a dictionary through a list of words */
//     public void buildDict(String[] dict) {
//         for(String s : dict) {
//             list.add(s);
//         }
//     }
//
//     /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
//     public boolean search(String word) {
//
//         for(String s : list) {
//             if(help(s, word)) {
//                 return true;
//             }
//         }
//         return false;
//     }
//
//     private boolean help(String s, String word){
//
//         int count = 0;
//         char[] arr1 = s.toCharArray();
//         char[] arr2 = word.toCharArray();
//         if(arr1.length != arr2.length) {
//             return false;
//         } else {
//             for(int i = 0; i < arr1.length; i++) {
//                 if(arr1[i] != arr2[i]) {
//                     count++;
//                     if(count > 1) {
//                         return false;
//                     }
//                 }
//             }
//             return count == 1;
//         }
//     }


    //method 3 use Trie

    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

        for(String s : dict) {
            TrieNode cur = root;
            for(char c : s.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] str = word.toCharArray();
        for(int i = 0; i < str.length; i++) {
            for(char cc = 'a'; cc <= 'z'; cc++) {
                if(str[i] == cc) {
                    continue;
                }
                char org = str[i];
                str[i] = cc;
                if(helper(root, new String(str))) {
                    return true;
                }
                str[i] = org;
            }
        }
        return false;
    }

    private boolean helper(TrieNode cur, String word) {
        for(char c : word.toCharArray()) {
            if(cur.children[ c - 'a']  == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

     public static void main(String[] args) {
         MagicDictionary magic = new MagicDictionary();
         String[] ss = { "hallo", "leetcode"};
         magic.buildDict(ss);
         System.out.print(magic.search("hello"));
     }
 }



