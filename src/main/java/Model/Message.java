package Model;

import java.util.List;

public class Message {
    private List<String> toEmail;
    private String fromEmail;
    private String subject;
    private String body;

    @Override
    public String toString() {
        return "To:" + String.join(",", toEmail) +
                "\nFrom:" + fromEmail +
                "\nSubject:" + subject +
                "\nBody:" + body ;
    }

    public Message(List<String> toEmail, String fromEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.subject = subject;
        this.body = body;
    }

    public List<String> getToEmail() {
        return toEmail;
    }

    public void setToEmail(List<String> toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
