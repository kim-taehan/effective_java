# int 상수 대신 열거 타입을 사용하라.

```text
- enum 은 밖에서 값을 변경할 수 없기 때문에 final로 불변이며, 싱글턴으로 보장된다.
```

## enum 장점
1. 컴파일 타입 안전성 제공 : Apple 열거타입 인수에 Orange를 넘길 수 없음
2. 이름 같은 상수 공존 : 각자의 이름공간이 있기 때문! 공개 되는 것이 필드의 이름이라 상수 값이 클라이언트에 컴파일 되어 각인되지 않기 때문이다.
3. 임의의 메서드나 필드를 추가할 수 있고 임의의 인터페이스를 구현하게 할 수 있다.
4. 상수를 하나 제거했을 때 : 제거한 상수를 참조하지 않는 클라이언트에 아무 영향이 없다.

## 행성 관련 Enum으로 생성
```java
public enum Planet {
    
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;           // 질량(단위: 킬로그램)
    private final double radius;         // 반지름(단위: 미터)
    private final double surfaceGravity; // 표면중력(단위: m / s^2)

    // 중력상수(단위: m^3 / kg s^2)
    private static final double G = 6.67300E-11;

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}
```

## enum 주요 기능

### 메서드를 각 상수별로 적용가능한다. 
```java
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    public abstract double apply(double x, double y);
```
