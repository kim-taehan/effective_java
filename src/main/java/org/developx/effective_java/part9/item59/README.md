# 정확한 답이 필요하다면 float와 double은 피하라.

```text
[DO NOT]
- double, float는 부동소수점을 빠르게 계산하기 위한 것이지 정확성을 가지지 못했다.
- 정확한 금액은 BigDecimal(성능이슈), 정수형(소수점 처리X) 로 하자.
```

```java
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
    
    // BigDecimal 로 구현
    public static BigDecimal calculatorBigDecimal(BigDecimal fund, BigDecimal price, int count) {
        for (int i = 0; i < count; i++) {
            fund = fund.subtract(price);
        }
        return fund;
    }
    
    // int로 구현 (센트로 계산됨)
    public static int calculatorInt(int fund, int price, int count) {
        for (int i = 0; i < count; i++) {
            fund -= price;
        }
        return fund;
    }

}
```