# Item82: 지연 초기화는 신중히 사용하라.

```text
[DO NOT]
- 대부분의 상황에서 일반적인 초기화가 지연 초기화보다 낫다. 
- 인스턴스 필드에 이중검사 관용구 방법.
- 정적 필드에는 지연 초기화 홀더 클래스를 사용하자.
```

## 이중검사 관용구

```java
public class DoubleCheckLazyInit {

    private volatile String field;

    private String getField() {
        String result = field;
        if (result != null) {
            return result;
        }
        synchronized (this) {
            if (field == null) {
                field =  computeFileValue();
            }
            return field;
        }
    }

    private String computeFileValue() {
        return UUID.randomUUID().toString();
    }
}
```

## 지연 초기화 홀더 클래스
```java
public class HolderLazyInit {
    private static String field;

    public static String getField() {
        return FieldHolder.field;
    }

    private static class FieldHolder {
        static final String field = computeField();
    }
    private static String computeField() {
        return UUID.randomUUID().toString();
    }
}
```