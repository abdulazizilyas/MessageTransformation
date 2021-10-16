package Rules;

import Model.Message;

import java.util.Locale;

public class ReplacementRule {
    public static String  applyReplacementRule(String message){
        System.out.println(message);
        //System.out.println(message.replaceAll("\\$","e").replaceAll("\\^","y").replaceAll("&","u"));
        return  message.replaceAll("\\$","e").replaceAll("\\^","y").replaceAll("&","u");
    }
}
