# 적시에 방어적 복사본을 만들라.

```text
[DO NOT]
- java.util.Date 는 가변이고 낡은 API 이니 새로운 코드 작성시에 Instant, LocalDateTime, ZonedDateTime 등을 사용하자.
- 가변 매개변수의 경우 방어적 복사를 통해 값을 변경할 수 없도록 하자.
```

## 방어적 복사 
> get 메서드 뿐 아니라 생성자를 통해서도 가능하다.

```java
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
        return start;
    }

    public Date end() {
        return end;
    }
}
```

```java
```