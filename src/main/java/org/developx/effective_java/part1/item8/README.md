# finalizer와 cleaner 사용을 피하라
> finalizer는 finalize 메소드를 오버라이드하여 Garbage Collect 대상이 될 때 수행된다.   
> 자바 9부턴 deprecated 되었고, Cleaner를 대안으로 지정한다.

## finalizer와 cleaner 문제점
> 실행 시점을 예측할 수 없고, 일반적으로 불필요하다. 
> finalizer 동작중 발생한 예외는 무시된다. 
> 심각한 성능 문제도 존재


## finalizer와 cleaner 대안 AutoCloseable
> AutoCloseable 인터페이스를 구현하고, 인스터스를 다쓰고 나면 close 메서드 직접 호출하자.  
> 일반적인 경우 뒤에서 나오는 try-with-resources 와 같이 사용하자 

```java
public interface AutoCloseable {
    void close() throws Exception;
}
```

```java
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public static Runnable Trash = () -> System.out.println("휴지통을 청소합니다.");

    public Room() {
        cleanable = cleaner.register(this, Trash);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
```