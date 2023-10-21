# 제너릭과 가변인수를 함께 쓸 때는 신중하라.
```text
- @SafeVarargs: 제너릭이나 매개변수화 타입의 varargs 매개변수를 받는 모든 메서드에 추가 
 ```

## Java에서 허용한 예
```java
public class Arrays {
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);
    }
}
```

## 임시로 구현한 예제
```java
public class GenericVarargs {
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> ret = new ArrayList<>();
        for (List<? extends T> list : lists) {
            ret.addAll(list);
        }
        return ret;
    }
}
```