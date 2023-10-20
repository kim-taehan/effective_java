# 상속보다는 컴포지션을 사용하라
> 상속은 코드를 재사용할 수 있는 강력한 수단이지만, 잘못 사용하면 객체의 유연성을 해치는 결과를 초래한다.

```text
[DO NOT]
여기서 상속(extends) 와 구현(implements)을 의미하는 것은 아니다.
private 필드로 기존 클래스의 인스턴스를 참조하게하는 컴포지션 방식
```

| 방법 | 설명|
|----|--|
| 상속 |	하위 클래스가 상위 클래스의 특성을 재정의 한것 > (IS-A) 관계|
| 컴포지션|	기존 클래스가 새로운 클래스의 구성요소가 되는것 > (HAS-A) 관계|

## ForwardingSet
> Set 구현체들을 구성요소로 만들고, 부가기능을 구현할 수 있게 한다.
```java
public class ForwardingSet<E> implements Set<E> {

    private final Set<E> set;

    public ForwardingSet(Set<E> set) {
        this.set = set;
    }
    // 생략 ...
}
```

## CustomSet
> Decorator pattern 을 활용해서 count 기능을 추가한다.
```java
public class CustomSet<E> extends ForwardingSet<E> {
    public CustomSet(Set<E> set) {
        super(set);
        count = 0;
    }

    private int count;
    public int getCount() {
        return count;
    }

    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }
}
```
