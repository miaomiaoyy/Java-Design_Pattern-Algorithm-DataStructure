import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MinSizeSubarray {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        res.get(1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(0);
        System.out.println(pq.toArray()[0]);
       // Arrays.sort(arr, (a, b) -> (getDis((Integer) a, x) - getDis((Integer)b, x)));
        System.out.println(Arrays.asList(pq.toArray()));

//            for(int i = 0; i < k; i++) {
//                res.add(arr[i]);
//            }
        return res;
    }


    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        //sliding window
        if(null == s || k <=0 )
            return 0;

        int len = s.length();
        if(len <= 1)
            return len;
        int start = 0, end = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < s.length()) {
            if(map.size() <= k) {
                map.put(s.charAt(end), end);
            }
            if(map.size() > k) {
                int min = Integer.MAX_VALUE;
                for(int i : map.values()) {
                    min = Math.min(min, i);//each time
                }
                start = min + 1;
                map.remove(s.charAt(min));//why can remove???
            }
            max = Math.max(end - start + 1, max);
            end++;
        }
        return max;
    }


//424
    public static int characterReplacement(String s, int k) {
        //count frq
        //change the highest frq
        int max = 0, len = 0;
        int[] count = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0 ; j < s.length(); j++) {
            max = Math.max(max, ++count[s.charAt(j) - 'A']);   //count the maxCount
            if(j - i + 1 - max > k) { //j - i + 1 是sliding windown 的len > max + k 是替换了k之后的一样长度,说明超过k个替换才能完成
                i++;
                count[s.charAt(i) - 'A']--;
            }
            len = Math.max(len, j - i + 1);
        }
        return len;
    }

    public static void main(String[] args) {
       // findClosestElements(new int[] {1,2}, 2, 2 );
        //lengthOfLongestSubstringKDistinct("aba",1);
        characterReplacement("ABAA", 0);
    }

}
