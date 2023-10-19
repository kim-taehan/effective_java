# 불필요한 객체 생성을 피하라.

## String, Long, Integer, Double, Float 등의 변수를 정의할 때 객체로 만들지 마라
> 불변의 객체를 생성시에는 객체를 하나를 재사용하는 것이 나을 때가 많다

```java
@DisplayName("[item6] 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라")
public class Item6Test {
    @DisplayName("String 하나의 객체를 사용하라")
    @Test
    void test576(){
        assertThat(new String("test"))
                .isNotSameAs(new String("test"));

        assertThat("test")
                .isSameAs("test");
    }
}
```

## 정적 팩터리를 제공하는 불변 클래스

```java
public class Item6Test {
    @DisplayName("값이 고정된 객체를 불변의 객체로 정의된 데이터를 사용하는 것 좋다.")
    @Test
    void fixEntityTest(){
        assertThat(Boolean.TRUE)
                .isSameAs(Boolean.TRUE);
    }
}
```

## 값비싼 객체를 재사용해 성능을 개선한다.
```java
public class RomanNumerals {

    private RomanNumerals(){
        throw new AssertionError();
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}

```

### 오토박싱(auto boxing) 주의하자
> 오토박싱은 프로그래머가 기본 타입과 박싱된 기본 타입을 섞어 쓸 때 자동으로 상호 변환해주는 기술이다.   
> 박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의하자.
```java
public class Sum {
    private static long sum() {
        Long sum = 0L; // Long 사용에 주의하자
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i; // long 타입인 i가 Long 타입인 sum에 더해질 때마다 객체가 생성된다.
        }
        return sum;
    }
}
```