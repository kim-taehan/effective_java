# 매개변수가 유효한지 검사하라.
```text
[DO NOT]
- 메서드는 최대한 범용적으로 설계해야 한다. 메서드가 건네받은 값으로 제대로 동작할 수 있다면, 매개변수 제약은 적을수록 좋다.
- 매개변수들에 어떤 제약이 있을지 생각해야 하며, 그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야 한다.
```
## 매개변수 검사
- 메서드가 수행되는 중간에 모호한 예외를 던지며 실패할 수 있다
- public과 protected 메서드는 매개변수 값이 잘못됐을 때 던지는 예외를 문서화해야 한다 (@throws 자바독 태그를 사용하면 된다).
```java
public class Item49 {
    /**
     * (현재 값 mod m) 값을 반환한다. 이 메서드는
     * 항상 음이 아닌 BigInteger를 반환한다는 점에서 remainder 메서드와 다르다.
     * @param m 계수(양수여야 한다)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같으면 발생한다.
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }
        // 계산 수행
        return null; // 편의상 null을 리턴했다.
    }
}
```

## 자바 7에 추가된 java.util.Objects.requireNonNull 
> 유연하고 사용하기도 편하니, 더 이상 null 검사를 수동으로 하지 않아도 된다.  
> throw new NullPointerException()
```java

public class Objects {
    // ...
    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }
}
```
