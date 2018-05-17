import java.util.*;

public class Solution{
    public int maximizeRating(int[] ratings){
        int size = ratings.length + 2;
        int[] dp = new int[size];

        for(int i = 2; i < size; ++i){
            if((dp[i - 1] + ratings[i - 2]) < (dp[i - 2] + ratings[i - 2])){
                dp[i] = dp[i - 2] + ratings[i - 2];    
            }
            else{
                dp[i] = dp[i - 1] + ratings[i - 2];
            }
        }

        return Math.max(dp[size - 1], dp[size - 2]);
    }

    public static void main(String[] args){
        int[] ratings;
        Solution sol = new Solution();

        ratings = new int[]{9, -1, -3, 4, 5};
        System.out.println("ratings: " + Arrays.toString(ratings));
        System.out.println("maximized rating: " + sol.maximizeRating(ratings));
        
        ratings = new int[]{-1, -2, -3, -4, -5};
        System.out.println("ratings: " + Arrays.toString(ratings));
        System.out.println("maximized rating: " + sol.maximizeRating(ratings));
    }
}
