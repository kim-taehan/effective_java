package org.developx.effective_java.part1.item1;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum MailType {
    GMAIL("gmail.com"), NAVER("naver.com");

    private final String text;

    public static MailType from(String text) {
        return Arrays.stream(MailType.values())
                .filter(mailType -> mailType.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("test"));
    }

}
