package org.developx.effective_java.part5.item31;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// 제네릭 타입으로 변경한 Stack
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void pushAll(Iterable<? extends E> src) {
        src.forEach(e -> push(e));
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
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

