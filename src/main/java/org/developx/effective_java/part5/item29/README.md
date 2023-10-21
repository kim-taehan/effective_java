# 이왕이면 제너릭 타입으로 만들라.

```text
- 직접 형변환해야 하는 타입보다 제네릭 타입이 더 안전하고 쓰기 편하다. 
- 기존 타입 중 제네릭이었어야 하는 게 있다면 제네릭 타입으로 변경
```

```java
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = (E) elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```