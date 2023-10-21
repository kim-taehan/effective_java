# 한정적 와일드카드를 사용해 API 유연성을 높여라.

```text
- 불공변인 제너릭을 보안하기 위해 나온 와일드 카드 문법입니다. 
- <? extends T>: T 하위객체까지 포함 
- <? super T>: T 상위객체까지 포함
- <T extends Comparable<? super T>>: Comparable 를 직접 구현하지 않고, 
  T가 상위의 객체로 Comparable를 구현한 객체까지 가능
- PECS: producer는 extends이고 consumer는 super 이다
```

## 한정적 와일드카드를 사용
```java
public class Stack<E> {
    ...
    public void pushAll(Iterable<? extends E> src) {
        src.forEach(e -> push(e));
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
    ...
}
```

## PECS
> PECS : producer - extends, consumer-super  
> 매개변수화 타입 T가 생산자인 경우 상한 경계 와일드 카드(<? extends E>)를 사용하고  
> 소비자이면 하한 경계 와일드카드(<? super E>)를 사용하라는 것이다.

## <E extends Comparable<? super E>>
> 혼란스럽다. 하지만 하나씩 분석하면 된다.  
> extends: Comparable을 상속받은 E를 허용한다  
> super: Comparable<E>를 직접상속받지 않고 Comparable<X> 를 상속받은 객체도 허용(단 E는 X의 하위 클래스)


## 와일드카드 캡처
```java
class test{
    public static void swap(List<?> list, int i, int j){
        swapHelper(list, i, j);
    };
    
    // Helper method created so that the wildcard can be captured
    // through type inference.
    public static <E> void swapHelper(List<E> list, int i, int j){
      list.set(i, list.set(j, list.get(i)));
    };
}
```