# 이왕이면 제너릭 메서드로 만들라.

```text
- 입력 매개변수와 반환값을 명시적으로 형변환해야 하는 메서드보다 제네릭 메서드가 더 안전하며 사용하기도 쉽다
- 형변환 없이 사용할 수 있는 편이 좋으며, 많은 경우 그렇게 하려면 제네릭 메서드를 사용하자
```

## 제너릭 메서드 예제
```java
public class Utils {
    private Utils() {
        throw new AssertionError();
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
```

## 제네릭 싱글턴 팩터리 (예제: Collection)
> 제네릭은 런타임에 타입 정보가 소거되므로 하나의 객체를 어떤 타입으로든 매개변수화할 수 있다.  
> 이렇게 하려면 요청한 타입 매개변수에 맞게 매번 그 객체의 타입을 바꿔주는 정적 팩터리를 만들어야 한다

```java
public class Collections {
    public static final Set EMPTY_SET = new EmptySet<>();

    @SuppressWarnings("unchecked")
    public static final <T> Set<T> emptySet() {
        return (Set<T>) EMPTY_SET;
    }

    private static class EmptySet<E>
            extends AbstractSet<E>
            implements Serializable {
        @java.io.Serial
        private static final long serialVersionUID = 1582296315990362920L;

        public Iterator<E> iterator() {
            return emptyIterator();
        }
        // ...
    }
}
```

## 재귀적 타입 한정

```java
public class Utils {
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }
}
```