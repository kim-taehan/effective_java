package org.developx.effective_java.part1.item1;

public final class NaverMail extends Email {
    public NaverMail(String address) {
        super(address, MailType.NAVER);
    }
}
