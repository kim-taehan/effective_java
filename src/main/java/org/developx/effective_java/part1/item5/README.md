# 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라


## 싱글턴/유틸리티 클래스의 문제점
```text
유틸리티 클래스 혹은 싱글턴 클래스는 상태를 가지면 멀티스레딩 환경에서 버그를 불러일으킬 수 있다.
테스트 하기가 어렵다. 싱글턴이 테스트 하기 어려운 예시는 여기
객체가 스스로 가지고 있는 자원(underlying resource)을 가지고 객체의 행동을 수행한다는 객체지향의 개념과 멀어진다.
```

```java
public class SpellChecker {
    private final Lexicon dictionary;
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.checkValidation();
    }
    public List<String> suggestions(String word) {
        return dictionary.suggestions(word);
    }
}
```

## 참조할 자원의 팩토리를 주입하기
-  Supplier<T>를 이용해 팩토리를 주입함으로써 더더욱 유연한 객체생성을 지원할 수 있다
```java
public class MosaicFactory {
    private MosaicFactory() {
        throw new AssertionError();
    }

    public static Mosaic create(Supplier<? extends Tile> tileFactory) {
        return new Mosaic(tileFactory.get());
    }
}
```
```java
public class Item5Test {
    @DisplayName("참조할 자원의 팩토리를 주입하기 Supplier")
    @Test
    void mosaicTest(){
        AdvanceTile advanceTile = new AdvanceTile();
        Mosaic mosaic = MosaicFactory.create(() -> advanceTile);

        assertThat(mosaic)
                .isNotNull()
                .extracting("tile")
                .isEqualTo(advanceTile);
    }
}
```

```text
- 클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면 
 싱글턴과 정적 유틸리티 클래스 사용하지 말자
- 의존 객체 주입이라 하는 이 기법은 클래스의 유연성, 재상용성, 테스트 용이성을 기막히게 개선한다.

```