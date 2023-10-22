# effective java 3E 독후감
> 전체 책 정리는 아니고, 개인적으로 몰랐던 내용만 학습용도로 정리함

## 2. 객체 생성과 파괴
> 객체를 만들어야 할 때와 만들지 말아야 할 때를 구분하는 법, 올바르게 객체 생성 방법과 불필요한 생성을 피하는 방법
- [Item1: 생성자 대신 정적 팩토리 매서드를 고려하라.](src/main/java/org/developx/effective_java/part2/item1)
- [Item2: 생성자에 매개변수가 많다면 빌더를 고려하라.](src/main/java/org/developx/effective_java/part2/item2)
- [Item3: private 생성자나 열거 타입으로 싱글턴임을 보증하라.](src/main/java/org/developx/effective_java/part2/item3)
- [Item4: 인스턴스화를 막으려거든 private 생성자를 사용하라.](src/main/java/org/developx/effective_java/part2/item4)
- [Item5: 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.](src/main/java/org/developx/effective_java/part2/item5)
- [Item6: 불필요한 객체 생성을 피하라.](src/main/java/org/developx/effective_java/part2/item6)
- [Item7: 다 쓴 객체 참조를 해제해라.](src/main/java/org/developx/effective_java/part2/item7)
- [Item8: finalizer와 cleaner 사용을 피하라.](src/main/java/org/developx/effective_java/part2/item8)
- [Item9: try-finally보다 try-with-resources를 사용하라.](src/main/java/org/developx/effective_java/part2/item9)


## 3장 모든 객체의 공통 메서드
> Object 에서 final 이 아닌 메서드를 언제 어떻게 재정의 해야 되는지 설명  
> 참고 final 이 아닌 메서드: equals, hashCode, toString, clone, finalize

- [Item10: equals는 일반 규약을 지켜 재정의하라.](src/main/java/org/developx/effective_java/part3/item10)
- [Item11: equals을 재정의하려거든 hashCode 도 재정의하라](src/main/java/org/developx/effective_java/part3/item11)
- [Item12: toString을 항상 재정의하라](src/main/java/org/developx/effective_java/part3/item12)
- [Item13: clone 재정의는 주의해서 진행하라.](src/main/java/org/developx/effective_java/part3/item13)
- [Item14: Comparable 을 구현할지 고려하라.](src/main/java/org/developx/effective_java/part3/item14)

## 4장 클래스와 인터페이스 
> 클래스와 인터페이스를 쓰기 편하고, 견고하며, 유연하게 만드는 방법

- [Item15: 클래스와 멤버의 접근 권한을 최소화하라.](src/main/java/org/developx/effective_java/part4/item15)
```text
- 모든 클래스와 멤버의 접근성을 가능한 좁히자. 
- package-private (이 접근제어자 사용도 고려)
- 배열, Collection 멤버는 불변리스트 만들어서 넘기던가 복사본을 넘기는 방식으로 진행
- 단순한 vo 객체의 경우 record 객체 생성을 고려
```
- [Item16: public 클래스에서 public 필드가 아닌 접근자 메서드를 사용하라.](src/main/java/org/developx/effective_java/part4/item16)
```text
- public 클래스에서 가변 필드를 직접 노출하해서 안된다 (불변필드도 조심)
- package 클래스나 중첩 private 클래스에서는 노출해도 큰 문제가 없다.
```

- [Item17: 변경 가능성을 최소화하라.](src/main/java/org/developx/effective_java/part4/item17)
```text
- 클래스는 꼭 필요한 경우가 아니라면 불변이어야 한다.
- 성능 때문에 어쩔 수 없다면 불변 클래스와 함께 가변 동반 클래스를 public 클래스로 제공하도록 하자.
- 불변으로 만들 수 없는 클래스라도 변경할 수 있는 부분을 최소한으로 줄이도록 하자.
- 한번 만들어진 불변객체는 재활용할 수 있게 상수로 제공하자 (쓰레드 safe)
```

- [Item18: 상속보다는 컴포지션을 사용하라](src/main/java/org/developx/effective_java/part4/item18)
```text
- 여기서 상속(extends) 와 구현(implements)을 의미하는 것은 아니다.
- private 필드로 기존 클래스의 인스턴스를 참조하게하는 컴포지션 방식
```

- [Item19: 상속을 고려해 설계하고 문서화하라.](src/main/java/org/developx/effective_java/part4/item19)
```text
- 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지(자기사용) 문서로 남겨야 한다. 
- 좋은 API 문서란 '어떻게'가 아닌 '무엇'을 하는지를 설명 (@implSpec)
- 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안 된다.
```

- [Item20: 추상 클래스보다는 인터페이스를 우선하라.](src/main/java/org/developx/effective_java/part4/item20)
```text
- interface 로 먼저 시도하고 interface 만으로 불가한 경우 골격 구현을 함께 제공하는 방법을 고려하자 (List, AbstractList)
- 다중상속은 안되는 점을 기억하고 (싱어송라이터) Mixin(Comparable, AutoCloseable) 인터페이스등 기법도 활용
```
- Item21: 인터페이스는 구현하는 쪽을 생각해 설계하라.
```text
- 기존 인터페이스에서 자바 8부터 사용가능한 default method 추가는 기존 구현체에 런타임오류를 발생시킬 수 있다. 
- default method 는 구현 클래스에서 재정의가 가능하다.  
```

- [Item22: 인터페이스는 타입을 정의하는 용도로만 사용하라.](src/main/java/org/developx/effective_java/part4/item22)
```text
- 상수 인터페이스는 안티패턴으로 사용하지 말자 (final class + private 생성자로 제한하여 상수 클래스 생성)
- 자바 7부터 상수 리터럴에 '_' 를 붙여 읽기 쉽게 만들수 있다 ( double pie = 3.141_592;)
```

- [Item23: 태그 달린 클래스보다는 클래스 계층구조를 활용하라](src/main/java/org/developx/effective_java/part4/item23)
```text
태그 달린 클래스: 두 가지 이상의 의미를 표한하며, 그 구분을 태그로 알려주는 클래스
```

- [Item24: 멤버 클래스는 되도록 static으로 만들라.](src/main/java/org/developx/effective_java/part4/item24)
```text
- 중첩 클래스는 다른 클래스 안에 정의된 클래스다. 중첩 클래스는 자신을 감싼 바깥 클래스에서만 쓰여야 한다.
- (비정적) 멤버 클래스는 바깥 인스턴스로의 숨은 외부 참조를 가지게 된다 (가비지 컬렉션 문제 발생)
```

- Item25: 톱 레벨 클래스는 한 파일에 하나만 담으라.
```text
- [DO NOT] 톱 레벨 클래스 2개 이상의 클래스는 컴파일러 순서에 따라 행위가 달라질 수 있다. 
- 정적 멤버 클래스로 하던가 별도의 클래스를 생성하자.
```

## 5장 제너릭 (자바 5)
> 제너릭의 이점을 최대로 살리고 단전을 최소화하는 방법

- [Item26: 로 타입은 사용하지 말라.](src/main/java/org/developx/effective_java/part5/item26)
```text
- 클래스와 인터페이스 선언에 타입 매개변수가 쓰이면 이를 제너릭 타입이라 한다. (제너릭 클래스, 제너릭 인터페이스)
- 로 타입(타입 매개변수가 없는 제너릭 타입) List, Collection -> List<String>, Collection<Integer>
```

- Item27: 비검사 경고를 제거하라
```text
- 재너릭과 관련된 비검사 경고를 무시하지 말자.   
- 가능한 범위를 좁혀서 @SuppressWarning("unchecked") 에너테이션으로 경고르 숨기고 주석으로 근거를 남겨라.
```

- [Item28: 배열보다는 리스트를 사용하라.](src/main/java/org/developx/effective_java/part5/item28)
```text
- 제너릭은 배열보다는 조금 느릴지만 런타임 classCatException 발생을 낮춰준다.
```

- [Item29: 이왕이면 제네릭 타입으로 만들라.](src/main/java/org/developx/effective_java/part5/item29)
```text
- 직접 형변환해야 하는 타입보다 제네릭 타입이 더 안전하고 쓰기 편하다. 
- 기존 타입 중 제네릭이었어야 하는 게 있다면 제네릭 타입으로 변경
```

- [Item30: 이왕이면 제네릭 메서드로 만들라.](src/main/java/org/developx/effective_java/part5/item30)
```text
- 입력 매개변수와 반환값을 명시적으로 형변환해야 하는 메서드보다 제네릭 메서드가 더 안전하며 사용하기도 쉽다
- 형변환 없이 사용할 수 있는 편이 좋으며, 많은 경우 그렇게 하려면 제네릭 메서드를 사용하자
```

- [Item31: 한정적 와일드카드를 사용해 API 유연성을 높여라.](src/main/java/org/developx/effective_java/part5/item31)
```text
- 불공변인 제너릭을 보안하기 위해 나온 와일드 카드 문법입니다. 
- <? extends T>: T 하위객체까지 포함 
- <? super T>: T 상위객체까지 포함
- <T extends Comparable<? super T>>: Comparable 를 직접 구현하지 않고, 
  T가 상위의 객체로 Comparable를 구현한 객체까지 가능
- PECS: producer는 extends이고 consumer는 super 이다
```

- [Item32: 제너릭과 가변인수를 함께 쓸 때는 신중하라.](src/main/java/org/developx/effective_java/part5/item32)
```text
- @SafeVarargs: 제너릭이나 매개변수화 타입의 varargs 매개변수를 받는 모든 메서드에 추가 
```

- [Item33: 타입 안전 이중 컨테이너를 고려하라.](src/main/java/org/developx/effective_java/part5/item33)
```text
- 타입 안정 이종 컨테이너 패턴: 컨테이너의 키를 매개변수화해서 값을 넣거나 뺄 때 키를 함께 제공
- Class<T>를 활용하는 방식
```

## 6장 열거 타입과 애너테이션

- [Item34: int 상수 대신 열거 타입을 사용하라.](src/main/java/org/developx/effective_java/part6/item34)
```text
- enum 은 밖에서 값을 변경할 수 없기 때문에 final로 불변이며, 싱글턴으로 보장된다.
```

- Item35: ordinal 메서드 대신 인스턴스 필드를 사용하라.
```text
- enum에서 제공하는 ordinal 메서드는 사용하지 말자 (해당상수가 몇번째인지 전달)
- JPA에서 Entity 에서 Enumulate 와 같은 의미이다.
```

- Item36: 비트 필드 대신 EnumSet을 사용하라.
```text
- EnumSet 클래스가 비트 필드 수준의 명료함과 성능, 그리고 열거 타입의 장점까지 제공해준다.
- EnumSet 대신 Collections.unmodifiableSet으로 EnumSet을 감싸 사용할 수 있다. (불변으로 사용시)
```

- [Item37: ordinal 인덱싱 대신 EnumMap을 사용하라.](src/main/java/org/developx/effective_java/part6/item37)
```text
- enum에서 제공하는 ordinal 메서드는 사용하지 말자
- EnumMap, EnumSet을 적극 사용하자
```

- [Item38: 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라.](src/main/java/org/developx/effective_java/part6/item38)
```text
- enum 을 상속 받을 수는 없지만 인터페이스를 implements 할 수 있다. (확장)
```

- Item39: 명명패턴보다 애너테이션 사용하라.
```text
- @Retention, @Target 을 활용하여 새로운 annotation을 생성한다. 
- 
```

- Item40: @Override 애너테이션을 일관되게 사용하라.
```text
- 오탈자로 인한 다중정의되는 것을 막아준다. 최악의 경우 런타임 애러로 발견될 수 있음 
- 또한 컴파일러 애러로 인해 잘못된 정의도 잡아주게 된다.
```

- Item41: 정의하려는 것이 타입이라면 마커 인터페이스를 사용하라.
```text
- 마커 애너테이션 타입이 ElementType.TYPE 이면 마커 인터페이스 사용을 고려해보자.
```

## 7장 람다와 스트림
> 자바 8에서 함수형 인터페이스, 람다, 메서드 참조라는 개념이 추가되었다.

- [Item42: 익명 클래스보다는 람다를 사용하라.](src/main/java/org/developx/effective_java/part7/item42)
```text
- 람다는 함수형 인터페이스에서만(하나의 메서드만 가진 인터페이스) 사용.
- 익명클래스는 추상클래스나 여러 메서드를 가진 인터페이스를 구현할 때 사용. 
```

- [Item43: 람다보다는 메서드 참조를 사용하라.](src/main/java/org/developx/effective_java/part7/item43)
```text
- 매개변수가 같은 메서드를 호출시에 람다식이 아닌 메서드참조 방식으로 처리할 수 있다.
- 둘중에 길이가 짧고 보기 좋은 쪽으로 쓰자.
```