import java.util.*;

public class WordCombination {
//    public static List<String> wordCombination (List<List<String>> input) {
//        List<String> res = new ArrayList<>();
//        dfs(res, input, 0,"");
//
//        return res;
//    }
//
//    private static void dfs(List<String> res, List<List<String>> input, int start , String s) {
//        if(start == input.size()) {
//            res.add(s);
//            return;
//        }
//
//        for(int i = 0; i < input.get(start).size(); i++) {
//            if(start == 0) dfs(res, input, start + 1, input.get(start).get(i));
//            else {
//                dfs(res, input, start + 1, s + " " + input.get(start).get(i));
//            }
//        }
//    }


        public static String getPermutation(int n, int k) {
            List<String> res = new ArrayList<>();
            if(k < 0) return "";
            dfs(res, n, 1, "");
            return res.get(k - 1);
        }

        private static void dfs(List<String> res, int n, int start, String s) {
            if(s.length() == n) {
                res.add(new String(s));
                return;
            }
            for(int i = start; i <= n; i++) {
                dfs(res, n, i + 1, s + i);
            }
        }


//    public static List<String> letterCombinations(String digits, Map<Integer, String> map) {
//
//        List<String> res = new ArrayList<>();
//        dfs(res, digits, map, 0, "");
//        return res;
//    }
//
//    private static void dfs(List<String> res, String digits, Map<Integer, String> map, int start, String s) {
//        if(start == digits.length()) {
//            res.add(s);
//            return;
//        }
//        for(int i = 0; i < map.get(digits.charAt(start) - '0').length(); i++) {
//            dfs(res, digits, map, start + 1, s + map.get(digits.charAt(start) - '0').charAt(i));
//        }
//    }

    public static void main(String[] args) {
        //WordDictionary wd = new WordDictionary();
        //String[] list1 = {"a","b","c"};
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"abc");
        map.put(2,"ydkl");
        map.put(3,"gfks");
//        List<String> l1 = Arrays.asList("a","b","tttc");
//        String[] list2 = {"c","k","y","v"};
//        List<String> l2 = Arrays.asList(list2);
//        List<List<String>> input = new ArrayList<>();
//        input.add(l1);
//        input.add(l2);
//        System.out.print(wordCombination(input));
        //System.out.print(letterCombinations("231", map));
        //System.out.print(getPermutation(2,2));
         String a = "abc";
         char[] c = a.toCharArray();
         c[0]= 'd';
         //System.out.println(c.toString());
         //System.out.println(new String(c));
         int num = 1;
         Integer b = 1;
         System.out.print(b.hashCode());
    }
}
