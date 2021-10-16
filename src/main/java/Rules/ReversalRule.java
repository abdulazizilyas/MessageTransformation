package Rules;

import Model.Message;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReversalRule {
    private static final Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");
    public static String applyReversalRule(String message){
        System.out.println("\n--------------\n"+message);
        System.out.println("\n--------------\n");
        String reversedMsg="\n";

        for (String s : LINE_SEP_PATTERN.split(message)) {
            reversedMsg+="\n"+Stream.of(s.split(" ")).map(msg -> new StringBuilder(msg).reverse().toString()).collect(Collectors.joining(" "));
        }
        return  reversedMsg;
    }
}
