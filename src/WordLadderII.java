import java.util.*;

public class WordLadderII {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) {
                return res;
            }
            List<String> path = new ArrayList<>();
            DFS(res, path, set, beginWord, endWord);
            System.out.print(res.toString());

            return res;
        }


        private void DFS( List<List<String>> res, List<String> path, Set<String> set, String st, String end) {
            if(st.equals(end)) {
                res.add(path);
            }
            char[] arr = st.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (char replace = 'a'; replace <= 'z'; replace++) {
                    arr[i] = replace;
                    String newStr = new String(arr);
                    if(set.contains(newStr)) {
                        DFS(res, path, set, newStr, end);
                    }
                }
            }
        }

    public int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();// Visited words

        int length = 1;
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int count = queue.size();// Level by level BFS

            for (int k = 0; k < count; k++) {
                char[] chs = queue.poll().toCharArray();

                for (int i = 0 ; i < chs.length; i++) {// Outer loop should be string
                    for (char ch = 'a'; ch <= 'z'; ch++) {// Inner loop should be 'a' - 'z'
                        char chOld = chs[i];
                        if (chs[i] == ch)
                            continue;

                        chs[i] = ch;
                        String cur = String.valueOf(chs);
                        if (endWord.equals(cur)) {
                            System.out.print(length);
                            return length + 1;
                        }
                        if (!visited.contains(cur) && wordList.contains(cur)) {
                            queue.offer(cur);
                            visited.add(cur);
                        }
                        chs[i] = chOld;
                    }
                }
            }
            length++; // Next round of longer transformation sequence
        }
        return 0;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
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
            step++;
        }
        System.out.print(step);
        return step;
    }

    public static void main(String[] args) {
        WordLadderII wd = new WordLadderII();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        list.add("cog");
        list.add("cot");
        list.add("dot");
        list.add("cag");
        list.add("cct");
        set.add("cog");
        set.add("cot");
        set.add("dot");
        set.add("cag");
        set.add("cct");
        wd.findLadders("cat", "cog", list);
        wd.ladderLength("cat", "cog", list);
        wd.ladderLength1("cat", "cog", set);
    }


    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        helper(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
    }

    boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
            return false;
        }

        if (set1.size() > set2.size()) {
            return helper(dict, set2, set1, map, !flip);
        }

        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;

                    String word = new String(chars);

                    // make sure we construct the tree in the correct direction
                    String key = flip ? word : str;
                    String val = flip ? str : word;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                    if (set2.contains(word)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(word)) {
                        set.add(word);

                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }

    void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
            return;
        }

        for (String word : map.get(start)) {
            sol.add(word);
            generateList(word, end, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}

