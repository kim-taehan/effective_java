# 멤버 클래스는 되도록 static으로 만들라.

```text
- 중첩 클래스는 다른 클래스 안에 정의된 클래스다. 중첩 클래스는 자신을 감싼 바깥 클래스에서만 쓰여야 한다.
- (비정적) 멤버 클래스는 바깥 인스턴스로의 숨은 외부 참조를 가지게 된다 (가비지 컬렉션 문제 발생)
```

## 중첩 클래스 종류
1. 정적 멤버 클래스
2. (비정적) 멤버 클래스  
3. 익명 클래스
4. 지역 클래스


## 1. 정적 멤버 클래스
> 클래스 내부에 static으로 선언된 클래스다.  
> 바깥 클래스의 private 멤버에도 접근 가능하며, private 선언시에 바깥 클래스에만 접근된다.

```java
public class StaticMemberClass {
    private final String name;

    public String getName() {
        return name;
    }

    private StaticMemberClass(String name) {
        this.name = name;
    }

    public static class Builder {
        private String name;
        public Builder(String name) {
            this.name = name;
        }
        public StaticMemberClass build() {
            return new StaticMemberClass(this.name);
        }
    }
}
```

## 2. (비정적) 멤버 클래스 
```java
public class HashMap<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable {

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        // size(), clear(), contains(), remove(), ...
    }

    final class KeySet extends AbstractSet<K> {
        // size(), clear(), contains(), remove(), ...
    }

    final class Values extends AbstractCollection<V> {
        // size(), clear(), contains(), remove(), ...
    }
}
```

## 3. 익명 클래스
> 즉석에서 작은 함수 객체나 처리 객체를 만드는 데 주로 사용

## 4. 지역 클래스

```java
public class TestClass {

    public void anonymous(){
        // 익명 클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
            runnable.run();
        };
    }
    public void local(){
        // 지역 클래스
        class LocalClass {
            private String name;
            // private static int staticNumber; // 정적 멤버 가질 수 없음

            public LocalClass(String name) {
                this.name = name;
            }

            public void print() {

            }
        }
        LocalClass test = new LocalClass("test");
        test.print();
    }
}
```