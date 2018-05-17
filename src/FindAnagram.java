import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagram {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s==null || p==null)
            return list;
        int slen=s.length(), plen=p.length();
        if(slen==0 || plen==0)
            return list;
        int[] pfreq = new int[26];
        for(int i=0;i<plen;i++) {
            pfreq[p.charAt(i)-'a']++;
        }

        int st=0,ed=0,count=plen;//length need to match p

        while(ed<slen) {
            if(pfreq[s.charAt(ed)-'a']>=1) {
                count--;
            }
            pfreq[s.charAt(ed)-'a']--;
            ed++;
            if(count==0)
                list.add(st);
            if(ed-st==plen)  {
                if(pfreq[s.charAt(st)-'a']>=0) {
                    count++;
                }
                pfreq[s.charAt(st)-'a']++;
                st++;
            }
        }
        return list;
    }


    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int counter = hashMap.size();
        int begin = 0, end = 0;

        while (end < s.length()) {
            char current = s.charAt(end);
            if (hashMap.containsKey(current)) {
                hashMap.put(current, hashMap.get(current) - 1);

                if (hashMap.get(current) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char tmp = s.charAt(begin);
                if (hashMap.containsKey(tmp)) {
                    hashMap.put(tmp, hashMap.get(tmp) + 1);

                    if (hashMap.get(tmp) > 0) {
                        counter++;
                    }
                }

                if (end - begin == p.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindAnagram anagram = new FindAnagram();

        String a = "abdcbcbdca";
        String b = "abc";

        anagram.findAnagrams(a,b);
    }
}
