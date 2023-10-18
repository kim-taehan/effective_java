# private 생성자나 열거 타입으로 싱글턴임을 보증하라

```text
불변식을 지키기 위해 인스턴스를 통제해야 한다면 가능한 한 열거 타입을 사용한다.
여의치 않은 상황에서 직렬화와 인스턴스 통제가 모두 필요하다면 readResolve 메서드를 작성해 넣어야 하고, 
그 클래스에서 모든 참조 타입 인스턴스 필드를 transient로 선언해야 한다.
```
 
```java
public class MySingleton implements Serializable {
    // 여기서는 singleton 객체를 생성하는 방식은 중요하지 않다.
    private static final MySingleton INSTANCE = new MySingleton();
    private MySingleton() {
        // private 하여 다른 클래스에 생성하지 못하게 한다.
        // 확실하게 표현 해주는 것도 좋은 방식이다.
        if (INSTANCE != null) {
            throw new IllegalStateException("MySingleton 객체는 한번만 생성할 수 있습니다");
        }
    }
    public static MySingleton getInstance() {
        return INSTANCE;
    }

    // 직렬화를 통한 추가 인스턴스 생성을 제한한다.
    private Object readResolve() {
        return INSTANCE;
    }
}
```

```java
public enum EnumSingleton {
    INSTANCE
}
```