# 람다보다는 메서드 참조를 사용하라.
```text
[DO NOT]
- 매개변수가 같은 메서드를 호출시에 람다식이 아닌 메서드참조 방식으로 처리할 수 있다.
- 둘중에 길이가 짧고 보기 좋은 쪽으로 쓰자.
```

## 메서드 참조 사용해보기
```java
public class Item43 {
    void methodReference() {
        Map<String, Integer> map = Map.of("1", 10, "2", 20, "3", 30, "4", 40);
        // 람다식 사용
        Integer mergeRamda = map.merge("1", 30, (count, incr) -> count + incr);
        // 메서드 참조
        Integer mergeReference = map.merge("1", 30, Integer::sum); 
    }
}
```

## 메서드 참조 정리 

### 1. 정적
```java
public final class Integer extends Number{
    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s,10);
    }
}
``` 
- 람다식표현: s -> Integer.parseInt(s)
- 메서드참조: Integer::parseInt

### 2. 한정적(인스턴스)
```java
public final class Instant {
    public boolean isAfter(Instant otherInstant) {
        return compareTo(otherInstant) > 0;
    }
}
```
- 람다식표현: t -> Instant.now().isAfter(t)
- 메서드참조: Instant.now()::isAfter

### 3. 비한정적(인스턴스)
```java
public final class String {
    public String toLowerCase() {
        return toLowerCase(Locale.getDefault());
    }
}
```
- 람다식표현: str -> str.toLowerCase()
- 메서드참조: String::toLowerCase

### 4. 클래스 생성자
```java
public class TreeMap<K,V> {
    public TreeMap() {
        comparator = null;
    }
}
```
- 람다식표현: () -> new TreeMap<K,V>()
- 메서드참조: TreeMap<K,V>::new

### 5. 배열 생성자
- 람다식표현: len -> new int[len]
- 메서드참조: int[]::new
