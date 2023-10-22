# 익명 클래스보다는 람다를 사용하라.

```text
[DO NOT]
- 람다는 함수형 인터페이스에서만(하나의 메서드만 가진 인터페이스) 사용.
- 익명클래스는 추상클래스나 여러 메서드를 가진 인터페이스를 구현할 때 사용. 
```

## 익명 클래스 
> 메서드를 하나만 담은 인터페이스의 인스턴스를 함수 객체하고 하며, 이를 만드는 주요 수단이 익명 클래스이다.

```java
public class test {
    public void comparable() {
        Comparable<Integer> comparable = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0;
            }
        };
    }
}
```

## 함수형 인터페이스 
> 자바 8에서는 추상 메서드 하나를 가진 인터페이스를 함수형 인터페이스라고 호칭한다.  
> 또한 이러한 함수형 인터페이스를 람다형태로 사용할 수 있다. 

```java
public class test {
    public void comparable() {
        Comparable<Integer> comparable = o -> 0;
    }
}
```