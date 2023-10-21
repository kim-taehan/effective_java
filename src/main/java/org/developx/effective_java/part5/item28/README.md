# 배열보다는 리스트를 사용하라.
```text
[DO NOT]
- 배열은 제네릭 타입, 매개변수화 타입, 타입 매개변수로 사용할 수 없다
- 제너릭은 배열보다는 조금 느릴지만 런타임 classCatException 발생을 낮춰준다.
```

```java
@DisplayName("Item28: 배열보다는 리스트를 사용하라.")
public class Item28Test {

    @DisplayName("배열의 경우 런타임시 애러가 발생한다.")
    @Test
    void arrayAnotherTypeTest(){
        Object[] objectArray = new Long[1];
        assertThatThrownBy(() -> objectArray[0] = "타입이 달라 넣을 수 없다.")
                .isInstanceOf(ArrayStoreException.class);
    }

    @DisplayName("배열의 경우 런타임시 애러가 발생한다.")
    @Test
    void ListAnotherTypeTest(){
//        List<Object> ol = new ArrayList<Long>(); // 컴파일시 애러를 확인
    }
}
```

```java
public class Chooser <T> {
    private final List<T> choices;

    public Chooser(Collection<T> choices) {
        this.choices = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choices.get(rnd.nextInt(choices.size()));
    }
}
```