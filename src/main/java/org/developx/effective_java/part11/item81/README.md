# Item81: wait와 notify보다는 동시성 유틸리티를 애용하라.

```text
- java.concurrent 고수준 유틸리티는 실행자 프레임워크, 동시성 컬렉션, 동기화 장치로 분류된다. 
- 동시성 컬렉션: List, Queue, Map 같은 표준 컬렉션 인터페이스에 동시성을 가미해 구현한 고성능 컬렉션이다
- 동기화 장치: 스레드가 다른 스레드를 기다릴 수 있게 하여, 서로 작업을 조율할 수 있게 해준다. (CountDownLatch, Semaphore, Phaser)
```
## Object의 wait, notify와 notifyAll
> 이 메서드들은 synchronized 블록 내에서 실행되어야 한다.  
> wait: 갖고 있던 고유 락을 해제하고, 스레드를 잠들게 한다.  
> notify, notifyAll: 호출로 잠들어 있던 스레드 임의의 하나/모두 깨운다.

## 동시성 컬렉션
> List, Queue, Map 같은 표준 컬렉션 인터페이스에 동시성을 가미해 구현한 고성능 컬렉션이다.

### ConcurrentMap 으로 구현한 동시성 정규화 맵
```java
public class Item81 {

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {

        String ret = map.get(s);
        if (ret == null) {
            ret = map.putIfAbsent(s, s);
            if (ret == null) {
                ret = s;
            }
        }
        return ret;
    }
}
```
### BlockingQueue 
> take 는 큐의 첫 원소를 꺼낸다. 이때 만약 큐가 비었다면 새로운 원소가 추가될 때까지 기다린다. 
> 대부분 Executor 서비스에서 이러한 blockingQueue 를 사용하고 있다.

## 동기화 장치 
> 스레드가 다른 스레드를 기다릴 수 있게 하여, 서로 작업을 조율할 수 있게 해준다.
> CountDownLatch, Semaphore이고 가장 강력한 동기화 장치는 Phaser이다

```java
public class Item81 {
    //...
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {

        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    // 모든 작업자 스레드가 준비될 때까지 기다린다.
                    start.await();
                    action.run();
                } catch (Exception e){
                    Thread.currentThread().interrupt();
                } finally {
                    // 타이머에게 작업을 마쳤음을 알린다.
                    done.countDown();
                }
            });
        }

        ready.await(); // 모든 작업자가 준비될 때까지 기다린다.
        long startNanos = System.nanoTime();
        start.countDown(); // 작업자들을 깨운다.
        done.await(); // 모든 작업자가 일을 끝마치기를 기다린다.
        return System.nanoTime() - startNanos;
    }
}

```