public class readFile {
//    public static int read4(char[] temp) {
//        String s = "helloworld";
//        char[] arr = s.toCharArray();
//        char[] r4 = new char[4];
//        int index = 0;
//        for(int i = 0; i < arr.length; i++) {
//            if(index < 4) {
//                temp[i] = arr[index++];
//                //r4[index++] = temp[i];
//            }
//        }
//        return index;
//    }

//    public static int readMore(char[] buff, int n) {
//        char[] temp = new char[4];
//        int len = 0;
//        while(true) {
//            int count = read4(temp);
//            count = Math.min(n - len, count);
//            for(int i = 0; i < count; i++) {
//                buff[len++] = temp[i++];
//            }
//            if(count < 4 || len                                                             == n) {
//                return len;
//            }
//        }
//    }

    public static String compareStr(String s, String t) {
    int[] tCounts = new int[56];
    int[] sCounts = new int[56];
    for(char c : t.toCharArray()) {
        tCounts[c - 'A']++;
    }
    int res = Integer.MAX_VALUE, match = 0, left = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
        sCounts[s.charAt(i) - 'A']++;
        if(sCounts[s.charAt(i) - 'A'] <= tCounts[s.charAt(i) - 'A']) {
            match++;
        }
        while(match == t.length()) {
            int window = i - j + 1;
            if(window < res) {
                left = j;
                res = window;
            }
            if(sCounts[s.charAt(j) - 'A'] > tCounts[s.charAt(j) - 'A']) {
                sCounts[s.charAt(j) - 'A']--;
                j++;
                // left = j;
            } else break;
        }
    }
    return res == Integer.MAX_VALUE ? "":s.substring(left,res+left);

}

    public static void main(String[] args) {
        char[] buff = new char[]{'a','e','b','c','d','d','w','d','d'};
        //readMore(buff, 9);
        compareStr("BADCEBAC", "ABCC");
    }
}
