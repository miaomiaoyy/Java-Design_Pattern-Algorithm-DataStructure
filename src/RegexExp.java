import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExp {
//replace all dog with cat

    public String replaceRegx(String orgin, String replace, String words) {
          String REGEX = orgin;
          String INPUT = words;
          String REPLACE = "cat";
          Pattern p = Pattern.compile(REGEX);

         // get a matcher object
         Matcher m = p.matcher(INPUT);
         INPUT = m.replaceAll(REPLACE);
         System.out.println(INPUT);
       return INPUT;
    }



    public static void main(String[] args) {
         String REGEX = "dog";
         String INPUT = "The dog says meow. " + "All dogs say meow.";
         String REPLACE = "cat";
         RegexExp rg = new RegexExp();
         rg.replaceRegx(REGEX,REPLACE,INPUT);
    }
}

