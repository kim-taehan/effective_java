# [Item20] 추상 클래스보다는 인터페이스를 우선하라.
```text
[DO NOT]
- interface 로 먼저 시도하고 interface 만으로 불가한 경우 골격 구현을 함께 제공하는 방법을 고려하자 (List, AbstractList)
- 다중상속은 안되는 점을 기억하고 (싱어송라이터) Mixin(Comparable, AutoCloseable) 인터페이스등 기법도 활용
```

## 골격 구현 클래스
> 랩퍼 클래스를 제공하는 방식도 가능하다 ([Item18 참고](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem18))  
> 관례상 Abstract 를 앞에 붙이는 방식을 사용한다.

```java
public interface Maps <K, V>{
    void put(K k, V v);
    V get(K k);
}
```

```java
public class AbstractMaps<K, V> implements Maps<K, V> {

    private WeakHashMap<K, V> Map = new WeakHashMap<>();
    @Override
    public void put(K k, V v) {
        Map.put(k, v);
    }

    @Override
    public V get(K k) {
        return Map.get(k);
    }
}
```
 

## 다중상속을 통해 아키텍쳐 구현
```java
public interface Singer {
    void sing();
}
```

```java
public interface Songwriter {
    void compose();
}
```

```java
public interface SingerSongwriter extends Singer, Songwriter{
    void strum();

    void actSensitive();
}
```