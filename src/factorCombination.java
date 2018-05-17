import java.util.*;

public class factorCombination {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, new ArrayList<>(), 2);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int n, List<Integer> tempList, int st) {
        if (n <= 1) {
            if(tempList.size() > 0) {
                res.add(new ArrayList<Integer>(tempList));
            }
        }
        //int i = tempList.size() == 0 ? 2:tempList.get(tempList.size() - 1); i <= n; i++)
        for (int i = st; i <= n; i++) {
            if (n % i == 0) {
                tempList.add(i);
                dfs(res, n / i, tempList, st);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static List<String> letterCombinations(String digits, Map<Character, List<Character>> map) {
       // Set<String> res = new HashSet<>();
        List<String> list = new ArrayList<>();
        dfs(map, digits, list, 0, "");
        //list.addAll(res);
        return list;
    }

    private static void dfs(Map<Character, List<Character>> map, String s, List<String> res, int start, String temp) {
        if(start == s.length()) {
            res.add(temp);
            return;
        }
        List<Character> word = map.get(s.charAt(start));
        Collections.sort(word);
        for(int i = 0 ; i < word.size(); i++) {
            if(i > 0 && word.get(i) == word.get(i-1)) {
                continue;
            }
            dfs(map, s, res, start + 1, temp + word.get(i));
        }
    }



    public static void main(String[] args) {
       // getFactors(10);
        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> list = Arrays.asList('1','2','2','4');
        List<Character> list2 = Arrays.asList('1','3','4');
        map.put('a',list);
        map.put('b',list2);
        map.put('c',list2);
        System.out.println(letterCombinations("ac", map));
    }
}

