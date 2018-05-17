import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    static Map<Character, String> map = new HashMap<>();
    public static boolean wordPatternMatch(String pattern, String str) {
        if(pattern.isEmpty()) return str.isEmpty();
        char c = pattern.charAt(0);
        if(map.containsKey(c)) {
            String temp = map.get(c);
            if(str.length() < temp.length() ||
                    !str.substring(0, temp.length()).equals(temp)
                    || !str.startsWith(temp)) {
                return false;
            }
            return true;
        }else {
            for(int i = 1; i <= str.length(); i++) {
                String sub = str.substring(0,i);
                if (map.containsValue(str.substring(0, i))) continue;
                map.put(c, sub);
                String next = str.substring(i);
                if(wordPatternMatch(pattern.substring(1), next)) {
                    return true;
                }
                map.remove(c);
            }
        }
        return false;
    }

   public static void main(String[] args) {
       // wordPatternMatch("ab","hghkks");
       wordPatternMatch("ab","aa");
   }
}


