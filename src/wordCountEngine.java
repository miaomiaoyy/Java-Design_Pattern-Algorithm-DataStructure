
import java.util.*;

public class wordCountEngine {
    public static String[][] wordCount(String doc) {
        StringBuilder sb = new StringBuilder();
        for (Character c : doc.toCharArray()) {

            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (c == ' ' || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        Map<String, Integer> map = new HashMap<>();
        String[] words = sb.toString().split(" ");
        for (String s : words) {
            //System.out.println(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    if (e1.getValue() != e2.getValue()) {
                        return e2.getValue() - e1.getValue();
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                }
            });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
            pq.offer(entry);
        }
        String[][] res = new String[pq.size()][2];
        //System.out.println(pq.size());
        //System.out.println(pq.toArray());
        int k = 0;
//        while(!pq.isEmpty()) {
//            Map.Entry<String, Integer> entry  = pq.poll();
//            res[k][0] = entry.getKey();
//            res[k++][1] = entry.getValue().toString();
//        }
        for (int i = 0; i < pq.size(); i++) {
            res[i][0] = pq.peek().getKey();
            res[i][1] = pq.poll().getValue().toString();
        }
        return res;
    }


    public static String[][] wordCount2(String doc) {
        StringBuilder sb = new StringBuilder();
        for (Character c : doc.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (c == ' ' || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        String[] words = sb.toString().split(" ");
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        //ArrayList<List<String>> bucket = new ArrayList<List<String>>(max);
        List<String>[] bucket = new ArrayList[max];
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int id = entry.getValue() - 1;
            if(bucket[id] == null) bucket[id] = new ArrayList<>();//不可以每次都直接set new 啊
            bucket[id].add(entry.getKey());
           // System.out.println(bucket);
        }
        String[][] res = new String[map.size()][2];
        int k = 0;
        for(int i = bucket.length - 1;  i >= 0; i--) {
            Collections.sort(bucket[i]);
            // if (bucket[i] == null) continue;
          // Arrays.sort(bucket[i].toArray());
            for(String s : bucket[i]) {
                res[k][0] = s;
                res[k++][1] = i + 1+ "";
            }
        }
        return res;
    }


    List<Map.Entry<String, Integer>> bucket = new ArrayList<>();

    static int LPS(char A[]) {
        if(A.length == 0) {
            return 0;
        }
        int dp[][] = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            dp[i][i] = 1;
        }
        for(int len = 2; len <= A.length; len++) {
            for(int i = 0; i + len <= A.length; i++) {
                int j = i + len - 1;
                if(A[i] == A[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][A.length-1];
    }
//we can transform string to char array to easy compute
    static int LCSubstring(char A[], char B[]) {
        if(A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1 ; i <= A.length; i++) {
            for(int j = 1 ; j <= B.length; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max =Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //String[][] res = wordCount2("Practice makes perfect, so we need to practice " +
                //"like practice everyday, so we can make it");
        //for (String[] r : res) {
            //System.out.print(r[0] + ":" + r[1]);
        //}
        System.out.print(LPS(new char[]{'A','B','A'}));
        System.out.print(LCSubstring(new char[]{'A','B','A'}, new char[]{'A','B','A','A'}));
    }
}