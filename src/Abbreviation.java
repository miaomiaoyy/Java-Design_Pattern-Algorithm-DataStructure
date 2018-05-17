import java.util.*;

public class Abbreviation {

    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String trans = "";
        for(String s : dict) {
            if(s.length() <= 3) res.add(s);
            else {
                for(int i = 1; i < s.length() - 2; i++) {
                    trans = abbreviate(s, i);
                    if(!map.containsKey(trans)) {
                        map.put(trans,s);
                        break;
                    }
                }
                if(trans.length() < s.length()) {
                    res.add(trans);
                } else {
                    res.add(s);
                }
            }
        }
        return res;
    }

    private String abbreviate(String s, int start) {
        StringBuilder sb = new StringBuilder();
        String temp = s.substring(0,start);
        sb.append(temp).append(s.length() - start - 1).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        Abbreviation ab = new Abbreviation();
        String[] input = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        List<String> in = Arrays.asList(input);
        ab.wordsAbbreviation(in);
    }
}

