# 가변인수는 신중히 사용하라.
```text
[DO NOT]
- 인수 개수가 일정하지 않은 메서드를 정의시에 가변인수 사용하자.
- 필수 매개변수는 가변인수 앞에 두고, 성능문제를 고민하자.
```

```java
public final class Item53 {
    private Item53() {
        throw new AssertionError();
    }

    static int sum(int... args) {
        int ret = 0;
        for (int arg : args) {
            ret += arg;
        }
        return ret;
    }

    static int min(int firstArg, int... args) {
        int ret = firstArg;
        for (int arg : args) {
            if (ret > arg) {
                ret = arg;
            }
        }
        return ret;
    }
}
```