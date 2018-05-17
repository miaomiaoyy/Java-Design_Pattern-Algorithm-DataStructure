import java.util.Arrays;

public class MovieRating {

        public int maximizeRating(int[] ratings){
            int size = ratings.length + 2;
            int[] dp = new int[size];

            for(int i = 2; i < size; ++i){
                if((dp[i - 1] + ratings[i - 2]) < (dp[i - 2] + ratings[i - 2])){
                    dp[i] = dp[i - 2] + ratings[i - 2];
                    System.out.println(dp[i]);
                }
                else{
                    dp[i] = dp[i - 1] + ratings[i - 2];
                }
            }

            return Math.max(dp[size - 1], dp[size - 2]);
        }

        public int movieRatings(int[] ratings) {
            if (ratings.length == 1) return ratings[0];
            int[] dp = new int[ratings.length];
            dp[0] = ratings[0];
            dp[1] = ratings[1] + Math.max(0, dp[0]);
            for (int i = 2; i < ratings.length; i++) {
                dp[i] = ratings[i] + Math.max(dp[i - 1], dp[i - 2]);
            }


            return Math.max(dp[ratings.length -1], dp[ratings.length - 2]);
        }

        public static void main(String[] args){
            int[] ratings;
            MovieRating sol = new MovieRating();

            ratings = new int[]{9, -1, -3, 4, 5};
            System.out.println("ratings: " + Arrays.toString(ratings));
            System.out.println("maximized rating: " + sol.maximizeRating(ratings));

            System.out.println("maximized rating: " + sol.movieRatings(ratings));

            ratings = new int[]{-1, -2, -3, -4, -5};
            System.out.println("ratings: " + Arrays.toString(ratings));
            System.out.println("maximized rating: " + sol.maximizeRating(ratings));

            System.out.println("maximized rating: " + sol.movieRatings(ratings));

        }
}


