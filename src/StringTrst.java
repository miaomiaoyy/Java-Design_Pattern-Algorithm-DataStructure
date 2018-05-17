import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringTrst {

    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(s, res,  0);
        return res;
    }

    private static void dfs(String s, List<String> res,  int start) {

        for(int i = start; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                 res.add( s.substring(0, i-1) + "--" + s.substring(i+1));
                //temp.charAt(i) = '-';
                start = i + 2;
                //break;
            }
        }

    }


    static StringBuilder sb = new StringBuilder();
    public static String decodeString(String s) {
        //Stack<String> st = new Stack<>();

        if(null == s || s.length() == 0) return "";
        int times = 0;
        for(int i = 0; i < s.length(); i++) {

            if(Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            if(Character.isDigit(s.charAt(i))) {
                times = s.charAt(i) - '0';
            }
            if(s.charAt(i) == '[') {
                while(times > 0) {
                    String temp = "";
                    while(i + 1 < s.length() && s.charAt(i + 1) != ']') {

                        temp += s.charAt(i + 1);
                        decodeString(temp);
                    }
                    sb.append(temp);
                    times--;
                }
            }
            if(s.charAt(i) == ']')
                continue;
        }
        return sb.toString();
    }

    public static int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }



    public static void main(String[] args) {
        String s = "++++";
        //generatePossibleNextMoves(s);
        //calculate("2*3+7/2");
        decodeString("2[a4[bc]]");
    }
}

