public class DP_Profile {
    public static int maxProfit(int m[], int P[], int k) {
        int maxP = 0;
        int dp[] = new int[m.length+1];
        dp[0] = 0;
        dp[1] = P[0];
        for(int i = 2; i <= m.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (i <= m.length-1 && m[i] - m[j] >= k) {
                    dp[i] = Math.max(dp[i], dp[j] + P[i - 1]);
                    maxP = Math.max(maxP, dp[i]);
                }
            }
        }
        return maxP;
    }

    public static boolean reconstruct(char[] str) {
        boolean[] dp = new boolean[str.length];
        dp[0] = true;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= str.length; i++) {

            sb.append(str[i]);
//            if(dict(sb.toString())) {
//                dp[i] = true;
//                sb = new StringBuilder();
//            }
        }
        return dp[str.length];
    }


    public static void main(String[] args) {
        int[] m = {2,3,4,5,6};
        int[] P = {100,9,2,46,3};
        System.out.print(maxProfit(m, P, 2));
    }
}
