package org.developx.effective_java.part8.item50;

import java.util.Date;

public final class Period {

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        // 원래 객체가 아닌 복사본으로 생성한다.
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}