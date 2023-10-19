# clone 재정의는 주의해서 진행하라.

## Cloneable

```text
Cloneable 는 복제해도 되는 클래스임을 명시하는 용도의 믹스인 인터페이스이다. 
Object clone 메서드의 동작 방식을 경정한다 
 - Cloneable을 구현한 클래스의 인스턴스에서 clone을 호출하면 그객체의 필드들을 하나하나 복사한 객첵 반환
 - Cloneable을 구현하지 않은 클래스의 인스턴스에서 clone을 호출하면 CloneNotSupportedException을 던진다
```

## clone() 재정의시 주의사항
```text
- clone 메서드가 super.clone()이 아닌, 생성자를 호출해 얻은 인스턴스를 반환해도 컴파일러는 동일한 인스턴스로 본다.
- 이 클래스의 하위 클래스에서 super.clone()을 호출한다면 잘못된 클래스의 객체가 만들어져, 결국 하위 클래스의 clone() 메서드가 제대로 동작하지 않게 된다.
- 상위 클래스의 clone() 값을 반환하면 안되고, 자신의 클래스 타입으로 변환한 뒤 반환 해야 한다.
- Shallow copy, Deep copy에 주의해서 구현해야 한다.
```

```text
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public Stack clone() {
        try {
            Stack clone = (Stack) super.clone();
            // 배열의 clone은 런타임 타입과 컴파일 타입 모두가 원본 배열과 같은 배열을 반환한다.
            // 따라서 배열을 복제할 때는 배열의 clone 메서드를 사용하라고 권장한다.
            // 배열은 clone 기능을 제대로 사용하는 유일한 예이다.
            clone.elements = elements.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
```

