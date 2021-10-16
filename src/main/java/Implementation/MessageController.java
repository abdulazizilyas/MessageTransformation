package Implementation;

import Model.Message;
import Rules.ReplacementRule;
import Rules.ReversalRule;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MessageController {
    private static final Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");
    public static Message getMessage(String fileContent){
            String[] messagePart=fileContent.split(System.lineSeparator(),4);
            return new Message(List.of(messagePart[0].substring(3).split(";")),messagePart[1].substring(5),messagePart[2].substring(8),messagePart[3].substring(6));
            }
    public static Message applyRules(Message message){
        if(hasTenDigits(message.getBody())){
            message.setBody(ReplacementRule.applyReplacementRule(message.getBody()));
            message.setBody(ReversalRule.applyReversalRule(message.getBody()));
        }
        else{
            if(hasSpecificSubject(message.getSubject())){
                message.setBody(ReversalRule.applyReversalRule(message.getBody()));
            }
            if(hasSpecificDomain(message.getToEmail())){
                message.setBody(ReplacementRule.applyReplacementRule(message.getBody()));
            }
        }
        return message;
    }

    private static boolean hasSpecificSubject(String subject) {
        return subject.startsWith("SECURE:");
    }

    private static boolean hasSpecificDomain(List<String> toEmail) {
        return toEmail.stream().anyMatch(s -> s.endsWith("domain.com"));
    }

    private static boolean hasTenDigits(String body) {
        return  Stream.of(LINE_SEP_PATTERN.split(body)).anyMatch(s->s.matches(".*\\d{9}+.*"));
    }
}
