# 반환 타입으로는 스트림보다 컬렉션이 낫다.

```text
[DO NOT]
- 원소 시퀀스를 반환하는 메서드를 작성할 때, 컬렉션을 반환하도록 하자. (stream 인터페이스가 Iterable을 지원하지 않음)
- Collection 인터페이스는 Iterable의 하위 타입이고, stream 메서드도 제공하니 둘다 제공하기 때문.
```

```java
public class Item47 {
    // Stream<E> -> Iterator<E> 로 중개하는 어댑터
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Iterator<E> -> Stream<E> 로 중개하는 어댑터
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
```