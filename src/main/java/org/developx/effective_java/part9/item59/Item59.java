package org.developx.effective_java.part9.item59;

import java.math.BigDecimal;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class Item59 {

    private Item59() {
        throw new AssertionError();
    }

    /**
     * 비지니스설명: 주머니에 있는 금액 1달러 10센트짜리 사탕 9개 구매시 잔돈을 거슬러주자
     */

    // double 로 구현
    public static double calculatorDouble(double fund, double price, int count) {
        for (int i = 0; i < count; i++) {
            fund -= price;
        }
        return fund;
    }

    public static BigDecimal calculatorBigDecimal(BigDecimal fund, BigDecimal price, int count) {
        for (int i = 0; i < count; i++) {
            fund = fund.subtract(price);
        }
        return fund;
    }

    public static int calculatorInt(int fund, int price, int count) {
        for (int i = 0; i < count; i++) {
            fund -= price;
        }
        return fund;
    }

}
