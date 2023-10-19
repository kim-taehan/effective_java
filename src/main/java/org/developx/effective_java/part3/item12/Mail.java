package org.developx.effective_java.part3.item12;

public class Mail {

    static enum MailType {
        GMAIL("gmail.com"), NAVER("naver.com");
        MailType(String text) {
            this.text = text;
        }
        private final String text;
    }

    private final String domain;
    private final MailType mailType;

    public Mail(String domain, MailType mailType) {
        this.domain = domain;
        this.mailType = mailType;
    }

    @Override
    public String toString() {
        return String.format("MAIL{ %s@%s }", domain, mailType.text);
    }
}
