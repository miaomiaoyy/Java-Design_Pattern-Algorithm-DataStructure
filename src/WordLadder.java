import java.util.*;

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            Queue<String> temp = new LinkedList<>();
            if(!set.contains(endWord)) {
                return 0;
            }

            set.remove(beginWord);

            int step = 0;
            Queue<String> q = new LinkedList<>();
            q.add(beginWord);
            while(!q.isEmpty()) {
                int size = q.size();
                for(int k = 0; k < size; k++) {
                    String top = q.poll();
                    char[] arr = top.toCharArray();
                    for(int i = 0 ; i < top.length(); i++) {
                        char old = arr[i];
                        for(char c = 'a'; c <= 'z'; c++) {
                            arr[i] = c;
                            String newStr = new String(arr);
                            if(set.contains(newStr)) {
                                System.out.print(newStr);
                                temp.add(newStr);
                                set.remove(newStr);
                            }
                        }
                        arr[i] = old;
                    }
                }
                q = temp;
                step++;
            }
            return step;
        }
    }

        public int ladderLengthTest(String beginWord, String endWord, List<String> wordList) {
            Queue<String> q = new LinkedList<>();
            Set<String> set = new HashSet<>(wordList);
            int step = 0;
            q.offer(beginWord);
            while(!q.isEmpty()) {
                String top = q.poll();

                for(int i = 0; i < top.length(); i++) {
                    if(top.equals(endWord)) {
                        return ++step;
                    }
                    char old = top.charAt(i);
                    char[] arr = top.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newContruct = new String(arr);
                        if(set.contains(newContruct)) {
                            q.offer(newContruct);
                            set.remove(newContruct);

                        }
                    }
                    arr[i] = old;
                }
                step++;
            }
            return step;
        }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<String> res = new ArrayList<>();
        for(String s : wordList) {
            res.add(s);
        }
        wordLadder.ladderLengthTest(beginWord, endWord, res);
    }
}


