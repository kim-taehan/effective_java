# Item22: 인터페이스는 타입을 정의하는 용도로만 사용하라.
```text
[DO NOT]
- 상수 인터페이스는 안티패턴으로 사용하지 말자 (final class + private 생성자로 제한하여 상수 클래스 생성)
- 자바 7부터 상수 리터럴에 '_' 를 붙여 읽기 쉽게 만들수 있다 ( double pie = 3.141_592;)
```

```java
public class PysicalConstants {

    private PysicalConstants(){}; // 인스턴스화 방지

    public static final double AVOGARDROS_NUMBER = 6.022_140_857e23;

    public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    public static final double ELECTRON_MASS = 9.109_383_56e-3;
}
```

```java
class Item22Test {
    @DisplayName("지름으로 원의 둘레를 구해보자.")
    @Test
    void calculatorCircleRound(){

        final int diameter = 10;
        double round = diameter * PieConstants.PIE;

        assertThat(round).isEqualTo(31.415_926_535_89);
    }
}
```