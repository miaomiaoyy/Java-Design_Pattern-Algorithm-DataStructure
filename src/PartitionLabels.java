import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        int[] table = new int[26];
        char[] stc = S.toCharArray();
        for(char c:stc)//count the occurence of each char in string
            table[c-'a']++;

        int i = 0, j = 0, l = S.length(), counter = 0;
        HashSet<Character> hs = new HashSet<>();
        while(j < l){
            char c = stc[j];
            if(!hs.contains(c)){// found new char in current window, so increase counter
                hs.add(c);
                counter++;
            }
            table[c-'a']--;
            j++;
            if(table[c-'a'] == 0){ // decrease the counter as we have exhausted the c char and remove char c from set
                counter--;
                hs.remove(c);
            }
            if(counter == 0){//if counter becomes 0, means current window is a partition
                res.add(j - i);//add length of current window
                i = j;// reset i for next window
            }
        }
        return res;
    }




        public List<Integer> partitionLabels2(String S) {
            List<Integer> res = new ArrayList<>();
            if(S == null || S.length() == 0) return res;

            int[] map = new int[26];
            for(int i=0; i<S.length(); i++){
                map[S.charAt(i) - 'a'] = i;
            }

            int last =0;
            int start = 0;

            for(int i=0; i<S.length(); i++) {
                last = Math.max(last, map[S.charAt(i) - 'a']);

                if(last == i){
                    res.add(last - start + 1);
                    start = last + 1;
                }
            }

            return res;
        }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
//        partitionLabels.partitionLabels("abcad");
        partitionLabels.partitionLabels2("abcad");
    }
}
