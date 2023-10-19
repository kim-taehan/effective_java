package org.developx.effective_java.part2.item1;

public final class NaverMail extends Email {
    public NaverMail(String address) {
        super(address, MailType.NAVER);
    }
}
