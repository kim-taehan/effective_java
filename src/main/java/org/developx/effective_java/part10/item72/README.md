# Item72: 표준 예외를 사용하라.

```text
[DO NOT]
- Exception, RuntimeException, Throwable, Error는 직접 재사용 하지 말자.
- 인수 값이 무엇이었든 어자피 실패했을 때는 IlleagalStateException 그렇지 않으면 IlleagalArgumentException을 던지자
```

# 널리 사용되는 표준 예외
| 예외                              | 주요 쓰임                                 |
|---------------------------------|---------------------------------------|
| IllegalArgumentException        | 허용하지 않는 값이 인수로 건네졌을 때 (null은 NPE로 처리) |
| IllegalStateException           | 객체가 메서드를 수행하기 적절하지 않은 상태일 때           |
| NullPointerException            | null을 허용하지 않는 메서드에 null을 건넸을 때        |
| IndexOutOfBoundsException       | 인덱스가 범위를 넘어섰을 때                       |
| ConcurrentModificationException | 허용하지 않는 동시 수정이 발견됐을 때                 |
| UnSupportedOperationException   | 호출한 메서드를 지원하지 않을 때                    |
| NumberFormatException           | Number 포맷 관련 애러가 발생시                  |
