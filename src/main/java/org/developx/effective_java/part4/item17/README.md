# 변경 가능성을 최소화하라.
```text
[DO NOT]
- 클래스는 꼭 필요한 경우가 아니라면 불변이어야 한다.
- 성능 때문에 어쩔 수 없다면 불변 클래스와 함께 가변 동반 클래스를 public 클래스로 제공하도록 하자.
- 불변으로 만들 수 없는 클래스라도 변경할 수 있는 부분을 최소한으로 줄이도록 하자.
- 한번 만들어진 불변객체는 재활용할 수 있게 상수로 제공하자 (쓰레드 safe)
```

## 불변 클래스 5가지 법칙
1. 객체의 상태를 변경하는 메서드를 제공하지 않늗다.
2. 클래스를 확장할 수 없도록 한다.
3. 모든 필드를 final로 선언
4. 모든 필드를 private로 선언
5. 자신 이외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
   (생성자, 접근자, readObject 메서드 모두에서 방어적 복사)


### Complex class
- plus 메서드는 인스턴스 자신은 수정하지 않고 새로운 Complex 인스턴스를 만들어서 반환한다.
- 이처럼 피연산자에 함수를 적용해 그 겨과를 반환하지만, 피연산자 자체는 그대로인 프로그래밍 패턴을 함수형 프로그래밍이라 한다.
```java
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex complex) {
        return new Complex(re + complex.re, im + complex.im);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
```