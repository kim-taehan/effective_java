package org.developx.effective_java.part3.item14;

public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private final String text;

    public CaseInsensitiveString(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(CaseInsensitiveString cid) {
        return String.CASE_INSENSITIVE_ORDER.compare(text, cid.text);
    }
}
