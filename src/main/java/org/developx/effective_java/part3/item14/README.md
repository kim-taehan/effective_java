# _Comparable 을 구현할지 고려하라._

## Comparable Interface
> 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현하여,  
> 그 인스턴스들을 쉽게 정렬하고, 검색하고, 비교 기능을 제공하는 컬렉션과 어우러 지도록 해야 한다.

```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```
```java
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
```


```java
public class PhoneNumber implements Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt
                    ((PhoneNumber phoneNumber) -> phoneNumber.areaCode)
            .thenComparingInt(phoneNumber -> phoneNumber.prefix)
            .thenComparingInt(phoneNumber -> phoneNumber.lineNum);


    private final Short areaCode;
    private final Short prefix;
    private final Short lineNum;

    public PhoneNumber(Short areaCode, Short prefix, Short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return COMPARATOR.compare(this, phoneNumber);
    }
}
```

```java
public class PhoneNumber implements Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt
                    ((PhoneNumber phoneNumber) -> phoneNumber.areaCode)
            .thenComparingLong(phoneNumber -> phoneNumber.prefix)
            .thenComparingDouble(phoneNumber -> phoneNumber.lineNum);


    private final Short areaCode;
    private final Long prefix;
    private final Double lineNum;

    public PhoneNumber(Short areaCode, Long prefix, Double lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return COMPARATOR.compare(this, phoneNumber);
    }
}
```