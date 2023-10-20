package org.developx.effective_java.part3.item14;

import java.util.Comparator;

;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt
                    ((PhoneNumber phoneNumber) -> phoneNumber.areaCode)
            .thenComparingLong(phoneNumber -> phoneNumber.prefix)
            .thenComparingDouble(phoneNumber -> phoneNumber.lineNum);


    private final int areaCode;
    private final long prefix;
    private final double lineNum;

    public PhoneNumber(int areaCode, long prefix, double lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return COMPARATOR.compare(this, phoneNumber);
    }
}
