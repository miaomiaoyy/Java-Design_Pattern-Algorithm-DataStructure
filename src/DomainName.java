import java.util.*;

public class DomainName {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> domainCount = new HashMap<>();
        for(String domain : cpdomains) {
            String[] domainParts = domain.split(" ");
            int times = Integer.valueOf(domainParts[0]);
            System.out.print(times);
            String domainName = domainParts[1];
            System.out.print(domainName);
            String[] subdomains = domainName.split("\\.");
            int start = 0;
            for(int i = 0; i < subdomains.length; i++) {
                String subcombination = domainName.substring(start);
                System.out.print(subcombination);
                start += subdomains[i].length() + 1;
                domainCount.put(subcombination, domainCount.getOrDefault(subcombination, 0) + times);
            }
            for(Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DomainName domainName = new DomainName();
//        String[] input = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
//        domainName.subdomainVisits(input);
        String test = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] ban = new String[] {"hit"};
        domainName.mostCommonWord(test, ban);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\\,\\.\\?]","");
        String[] words = paragraph.toLowerCase().split(" ");
        Set<String> set = new HashSet();
        String res = "";
        int max = Integer.MIN_VALUE;
        for(String banword : banned) {
            set.add(banword);
        }
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!set.contains(word)) {
                map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }


}
