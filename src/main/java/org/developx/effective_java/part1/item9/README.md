# try-finally보다 try-with-resources를 사용하라
> 닫아야 하는 자원이 있는 클래스를 만드는 경우 AutoCloseable을 반드시 구현하자.  
> AutoCloseable이 구현되어 있는 클래스를 사용하는 경우 try-finally보다 try-with-resources를 사용하자

```java
public interface AutoCloseable {
    void close() throws Exception;
}
```
```java
public class StreamReader<T> implements AutoCloseable {
    private Stream<T> stream;
    public StreamReader(Stream<T> stream) {
        this.stream = stream;
    }
    @Override
    public void close() throws Exception {
        System.out.println("close method call");
        stream.close();
    }
}
```