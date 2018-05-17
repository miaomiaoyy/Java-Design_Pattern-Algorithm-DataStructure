import java.util.*;

public class testLeetcode {
    public static void main(String[] args) {
        int res = (-123)%10;
        //System.out.print(res);
        //isMatch("aab","a*");
        //diffWaysToCompute("2*3-4*5");
        char[] task = new char[] {'A','B','A','C','A','B'};
        leastInterval(task, 3);
        leastInterval(task, 2);
    }
//
//    public static boolean isMatch(String s, String p) {
//
//        if (s == null || p == null) {
//            return false;
//        }
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        dp[0][0] = true;
//        for (int i = 0; i < p.length(); i++) {
//            if (p.charAt(i) == '*' && dp[0][i-1]) {
//                dp[0][i+1] = true;
//            }
//        }
//        for (int i = 0 ; i < s.length(); i++) {
//            for (int j = 0; j < p.length(); j++) {
//                if (p.charAt(j) == '.') {
//                    dp[i+1][j+1] = dp[i][j];
//                }
//                if (p.charAt(j) == s.charAt(i)) {
//                    dp[i+1][j+1] = dp[i][j];
//                }
//                if (p.charAt(j) == '*') {
//                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
//                        dp[i+1][j+1] = dp[i+1][j-1];
//                    } else {
//                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
//                    }
//                }
//            }
//        }
//        return dp[s.length()][p.length()];
//    }


        public static String leastInterval(char[] tasks, int n) {
            //JaN 19TH yANG :   Solution 1 using PQ
            //Map<Character, Integer> map = new HashMap<>();
//         for(char c : tasks) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
//             public int compare(Integer a, Integer b) {
//                 return b - a;
//             }
//         });
//         for(Map.Entry<Character, Integer> entry : map.entrySet()) {
//             pq.offer(entry.getValue());
//         }
//         List<Integer> waiting = new ArrayList<>();
//         int timer = 0;
//         while(!pq.isEmpty() || !waiting.isEmpty()) {
//             if(timer % (n + 1) == 0) {
//                 pq.addAll(waiting);
//                 waiting.clear();
//             }
//             if(!pq.isEmpty()){
//                 int inUseTask = pq.poll();
//                 inUseTask--;
//                 if(inUseTask > 0) {
//                     waiting.add(inUseTask);
//                 }
//             }
//             timer++;//no matter we use task or idel the timer will keep increase
//         }
//         return timer;
//     }
// }

            //Jan 19th if need to print the task result:
            String res = "";
            Map<Character, Integer> map = new HashMap<>();
            for(char c : tasks) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> pq =
                    new PriorityQueue<Map.Entry<Character, Integer>>(new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            });
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                pq.offer(entry);
            }
            List<Map.Entry<Character, Integer>> waiting = new ArrayList<>();
            int timer = 0;
            while(!pq.isEmpty() || !waiting.isEmpty()) {
                if(timer % (n + 1) == 0) {
                    pq.addAll(waiting);
                    waiting.clear();
                }
                if(!pq.isEmpty()) {
                    Map.Entry<Character, Integer> inUseTask = pq.poll();
                    res += inUseTask.getKey();
                    map.put(inUseTask.getKey(), inUseTask.getValue() - 1);
                    if(inUseTask.getValue() > 0) {
                        waiting.add(inUseTask);
                    }
                } else {
                    res += '*';
                }
                timer++;//no matter we use task or idel the timer will keep increase
            }
            System.out.println(res);
            return res;
        }









    public  static List<Integer> diffWaysToCompute(String input) {
            //记忆化递归 Yang Jan19th
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '+' || c == '-' || c =='*') {
                    String a = input.substring(0, i);
                    String b = input.substring(i+1);
                    List<Integer> res1 = diffWaysToCompute(a);
                    List<Integer> res2 = diffWaysToCompute(b);
                    for(int x : res1) {
                        for(int y : res2) {
                            if(c == '+') {
                                res.add( x + y );
                            } else if(c == '-') {
                                res.add( x - y );
                            } else {
                                res.add( x * y );
                            }
                        }
                    }
                }
            }
            if( res.size() == 0 )res.add(Integer.valueOf(input));
            return res;
        }
    }



