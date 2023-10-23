# Item78: 공유 중인 가변 데이터는 동기화해서 사용하라.

```text
- 여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화해야 한다. 
> 배타적 실행은 필요 없고 스레드 끼리의 통신만 필요하다면 volatile 한정자만으로 동기화는 가능하다. (하지만 원자성은 보장 X)
> AtomicLong, AtomicInteger 등을 사용해서 원자성까지 보존할 수 있다.
```

## synchronized 키워드
> 해당 메서드나 블록을 한번에 한 스레드씩 수행하도록 보장한다.   
> 배타적 실행은 필요 없고 스레드 끼리의 통신만 필요하다면 volatile 한정자만으로 동기화는 가능하다. (하지만 원자성은 보장 X)

```java
public class StopThreadSynchronized {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        System.out.println("requestStop call");
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested())
                i ++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
```

## volatile 키워드
- volatile keyword는 Java 변수를 Main Memory에 저장하겠다라는 것을 명시하는 것입니다.
- 매번 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것입니다.
- 또한 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것입니다.
- volatile 한정자는 배타적 수행과는 상관없지만 항상 가장 최근에 기록된 값을 읽게 됨을 보장한다.

```java
public class StopThreadVolatile {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i ++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
```

## Atomic~
> 이 패키지는 원자성까지 지원한다. 그리고 성능도 동기화 버전보다 우수하다.

```java
public class StopThreadAtomic {
    private static AtomicBoolean stopRequested = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested.get())
                i ++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested.set(true);
    }
}
```