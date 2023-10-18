package org.developx.effective_java.part1.item1;

import lombok.Getter;

@Getter
public sealed class Email permits Gmail, NaverMail{

    private final String address;
    private final MailType domain;


    private static Email adminEmail = new Email("kimtaehan", MailType.GMAIL);

    public static Email createByFullName(String emailFullName) {
        String[] emailInfo = divideFullName(emailFullName);
        MailType mailType = MailType.from(emailInfo[1]);
        if (mailType.equals(MailType.GMAIL)) {
            return new Gmail(emailInfo[0]);
        }
        return new NaverMail(emailInfo[0]);
    }

    private static String[] divideFullName(String emailFullName) {
        String[] texts = emailFullName.split("@");
        if (texts.length != 2) {
            throw new IllegalArgumentException("잘못된 이메일 주소입니다.");
        }
        return texts;
    }

    public Email(String address, MailType domain) {
        this.address = address;
        this.domain = domain;
    }

    public static Email getAdminEmail() {
        return adminEmail;
    }

    public static Email createGmail(String address) {
        return new Gmail(address);
    }

}
