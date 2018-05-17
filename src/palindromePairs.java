import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class palindromePairs {

//    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//    For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.

    public static boolean isPL(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while(start < end) {
            while(!Character.isLetter(s.charAt(start))) {
                start++;
            }
            while(!Character.isLetter(s.charAt(end))) {
                end--;
            }
            if(Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//O(n * k^2) O(n)
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new LinkedList<>();
        if (words == null) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
        for (int i = 0; i < words.length; ++ i) {
            int l = 0, r = 0;
            while (l <= r) {
                String s = words[i].substring(l, r);//
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                if (r < words[i].length()) ++r;
                else ++l;
            }
        }
        return pairs;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }

    public static int longestPalindromeSequence(String s) {
        //"bbbab" 5
//            dp[0][0] = 1; dp[0][1] = dp[1][0] + 2 = 2
//            dp[0][1] = max(dp[1][1], dp[0][0]) = 0
//            j = 2, i = 1, dp[1][2] = dp[2][1] + 2 = 2
//            dp[1][2] = max(dp[1][1], dp[2][2]) = 0

            int n = s.length();
            char[] array = s.toCharArray();
            int[][] dp = new int[n][n]; //dp[i][j] means in string s, from index i to j, the longest palindrome.
            for(int j = 0; j < n; j++){
                dp[j][j] = 1;
                for(int i = j - 1; i >= 0; i--){
                    if(array[i] == array[j]) dp[i][j] = dp[i + 1][j - 1] + 2; // if chars at two end is same, lenght + 2.
                    else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

            return dp[0][n - 1];
    }

    class inner {

        int lo = 0, max = 0;

        public  String longestPalindromeSubstring(String s) {
            int len = s.length();
            if (len < 2) return s;
            for (int i = 0; i < s.length(); i++) {
                findPalindrome(s, i, i);
                findPalindrome(s, i, i + 1);
            }
            return s.substring(lo, lo + max);
        }

        private  void findPalindrome(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (max < end - start - 1) {
                lo = start + 1;
                max = end - start - 1;
            }

        }
    }

    //dp(i, j) represents whether s(i ... j) can form a palindromic substring,
    // dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
    // When we found a palindrome, check if it’s the longest one. Time complexity O(n^2).

    public String longestPalindromeSubstring2(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        for(List<Integer> res : palindromePairs(words)) {

                System.out.println(res);
        }

        System.out.println(isPL("hello  olleh   "));
        System.out.println(isPL("A man, a plan, a canal: Panama"));
    }
}
