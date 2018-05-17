import java.util.HashMap;
import java.util.Map;

public class MinDistanceofString {

        Map<String, DisPair> map;

        class DisPair{
            int min;
            int max;
            DisPair(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }
        public MinDistanceofString(String[] words) {

            map = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                DisPair dispair = new DisPair(Integer.MAX_VALUE, Integer.MIN_VALUE);
                if(!map.containsKey(words[i])) {
                    dispair.min = Math.min(dispair.min, i);
                    dispair.max = Math.max(i, dispair.max);

                } else {
                    dispair.min = Math.min(map.get(words[i]).min, i);
                    dispair.max = Math.max(map.get(words[i]).max, i);
                }
                map.put(words[i], dispair);
            }
        }

        public int shortest(String word1, String word2) {
            DisPair p1 = map.get(word1);
            DisPair p2 = map.get(word2);
            int min1 = Math.abs(p1.max - p2.min);
            int min2 = Math.abs(p1.min - p2.max);

            return Math.min(min1, min2);
        }

    public static void main(String[] args) {
        String[] words = {"a", "c", "b", "b", "a"};
        MinDistanceofString st = new MinDistanceofString(words);
        System.out.println(st.shortest("a", "b"));
        }
    }


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

