# 다 쓴 객체 참조를 해제해라.
> 자바는 가비지 컬렉션을 가진 언어지만 그래도 메모리 관리를 해야되는 측면이 있다.

## 자기 메모리를 직접 관리하는 클래스
> 자기 메모리를 직접 관리하는 경우 (예제:Stack) 
> 아래 예제에서 pop 메서드를 확인하면, size는 줄였지만 여전히 elements 에는 데이터가 존재한다
> null 로 할당된 객체를 해주는 습관을 가지자

```java
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```


## 캐시
> 개체 참조를 캐시에 넣고 나서, 그 객체를 단 쓴 뒤로도 나두는 경우

### WeakHashMap
> 외부에서 키를 참조하는 동안만 엔트리가 살아 있는 캐시인 경우 사용 가능
```java
class Item7Test {
    @DisplayName("외부에서 키를 참조하는 동안만 엔트리가 살아 있는 캐시인 경우 사용 가능")
    @Test
    void weakHashMapTest(){
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key1 = 1000;
        Integer key2 = 2000;

        map.put(key1, "홍길동");
        map.put(key2, "류관순");
        key1 = null; // 외부에서 키를 참조 해제함

        System.gc();
        map.entrySet().stream().forEach(m -> System.out.println(m));
    }
}
```
### LinkedHashMap
> 캐시에 새 엔트리 추가할때 부수작업으로 removeEldestEntry 메서드를 호출


### Soft, Weak, Phantom Reference
> java.lang.ref는 soft reference와 weak reference, phantom reference를 클래스 형태로 제공한다.   
> 예를 들면, java.lang.ref.WeakReference 클래스는 참조 대상인 객체를 캡슐화(encapsulate)한 WeakReference 객체를 생성한다.   
> 이렇게 생성된 WeakReference 객체는 다른 객체와 달리 Java GC가 특별하게 취급한다(이에 대한 내용은 뒤에서 다룬다).   
> 캡슐화된 내부 객체는 weak reference에 의해 참조
> [Java Reference와 GC 관련 참고](https://d2.naver.com/helloworld/329631)
> 
>

## 리스너와 콜백 
> 클라이언트 콜백을 등록만 하고 명확히 해지 하지 않으면 콜백은 쌍혀간다. 
> 이때도 약한 참조로 저장할 필요가 있다.