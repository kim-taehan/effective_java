# equals는 일반 규약을 지켜 재정의하라.

## equals를 재정의 하지 말아야 하는 경우
1. 값이 아닌 Thread 와 같이 동작하는 개체를 표현하는 클래스라면, 재정의할 필요가 없다.
2. 인스턴스의 논리적 동치성(logical equality)를 검사할 일이 없는 경우
3. 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는 경우
4. 클래스가 private이거나 package-private이며, equals 메서드 호출할 일이 없는 경우

## equals 규약 (공통 : null이 아닌 모든 참조 값 x에 대해)
| 명칭| 설명|
| --| --|
|반사성|x.equals(x)는 true이다.|
|대칭성|x.equals(y)가 true이면 y.equals(x)도 true이다.|
|추이성|x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true이다.|
|일관성|x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.|
|null-아님|x.equals(null)은 false 이다.|

## equals 구현 절차
1. == 연산자를 사용해 입력된 파라미터와 자기자신이 같은 객체인지 검사한다. (동일성 검사 - Object Identity)
2. instanceof 연산자로 파라미터의 타입이 올바른지 체크 (묵시적 null체크 용도로도 사용)
3. 입력을 올바른 타입으로 형변환한다.
4. 파라미터 Object 객체와 자기자신의 대응되는 핵심필드들이 모두 일치하는지 확인한다.
5. 하나라도 다르면 false를 리턴
6. float, double을 제외한 기본타입은 ==을 통해 비교
7. 참조(reference) 타입은 equals를 통해 비교
8. float, double은 Float.compare(float, float)와 Double.compare(double, double)로 비교한다 
9. 배열의 모든 원소가 핵심 필드라면 Arrays.equals를 사용하자
10. 다를 확률이 높은 필드부터 비교한다 .비교하는 비용(시간복잡도)이 적은 비교를 먼저 수행

## Sample Equals

```java
public class SampleClass {

    private final int basic;
    private final String reference;
    private final double _double;
    private final String[] strings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        SampleClass that = (SampleClass) o; 
        return basic == that.basic 
                && Double.compare(that._double, _double) == 0
                && Objects.equals(reference, that.reference) 
                && Arrays.equals(strings, that.strings); 
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(basic, reference, _double);
        result = 31 * result + Arrays.hashCode(strings);
        return result;
    }
}
```



