public class MinWindowSubstring {

        public static String minWindow(String s, String t) {
            int[] sCount = new int[128];
            int[] tCount = new int[128];
            int match = 0, i = 0, start = 0, res = Integer.MAX_VALUE;
            for(char c : t.toCharArray()) {
                tCount[c]++;
            }
            while(i < s.length()) {
                char c = s.charAt(i); //cur index 右移去match更多的T
                if(++sCount[c] <= tCount[c]) {
                    match++;//只要scount看到这个char的次数小于tcount说明你还在match string t。当他大于的时候说明你已经包含完所有string t中的所有的这个char了。再来多的也不会改变你对string t的match数量。
                }
                while(match == t.length()) {
                    int len = i - start + 1;
                    if(len < res) {
                        res = len;
                    }
                    if(sCount[s.charAt(start)] > tCount[s.charAt(start)]) { //从头开始删除多余的
                        sCount[s.charAt(start)]--;
                        start++;
                    } else {
                        break; //打破了while loop
                    }
                }
                i++;
            }
            return s.substring(start, start + res);
        }

    public static void main(String[] args) {
        System.out.println(minWindow("aabbca", "abc"));
    }

}
