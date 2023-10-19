package org.developx.effective_java.part2.item1;

public final class Gmail extends Email {
    public Gmail(String address) {
        super(address, MailType.GMAIL);
    }
}
