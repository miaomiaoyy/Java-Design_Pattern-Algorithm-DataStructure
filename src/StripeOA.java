import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StripeOA {

    public static String[] replace(String[] lines) {
        String[] results = new String[lines.length];
        for(int i = 0;i < lines.length;i++) {
            String currentLine = lines[i];
            String result = "";
            if(currentLine.startsWith("API")) {
                result = setMask(currentLine);
            } else if(currentLine.startsWith("BANK")) {
                result = removeMask(currentLine);
            }
            results[i] = result;
        }
        return results;
    }

    public static String setMask(String line) {
        String cardNumber = getCardNumber(line);
        String firstSixChars = cardNumber.substring(0, 6);
        String lastFourChars = cardNumber.substring(cardNumber.length()-4);
        Pattern pattern = Pattern.compile("card=[0-9]{15,16}");
        Matcher matcher = pattern.matcher(line);
        String result = matcher.replaceAll("card=" + firstSixChars + "XXXXXXXXXXXXXXXXXXXX" + lastFourChars);
        return result;
    }

    public static String removeMask(String line) {

        Pattern pattern = Pattern.compile("card=[0-9]{2}");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        String firstTwoChars = matcher.group().substring(5);

        StringBuilder replacement = new StringBuilder();
        for(int i = 0;i < 3;i++) {
            replacement.append(firstTwoChars);
        }

        Pattern cardPattern = Pattern.compile("X{20}");
        Matcher cardMatcher = cardPattern.matcher(line);
        String result = cardMatcher.replaceAll(replacement.toString());
        return result;
    }

    public static String getCardNumber(String line) {
        Pattern pattern = Pattern.compile("card=[0-9]{15,16}");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        String cardNumber = matcher.group().substring(5);
        return cardNumber;
    }

}
