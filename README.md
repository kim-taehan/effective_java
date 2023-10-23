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

- [Item44: 표준 함수형 인터페이스를 사용하라.](src/main/java/org/developx/effective_java/part7/item44)
```text
- java.util.function 에 정의된 표준 함수형 인터페이스를 사용하자. (Supplier, Function, Consumer, Predicate)
- @FunctionalInterface 애너테이션으로 함수형 인터페이스 임을 알려라.
```

- Item45: 스트림은 주의해서 사용하라.
```text
- 람다에서는 final이 아닌 지역변수를 수정할 수 없다. 
- return, break, continue 사용할 수 없다.
```

- [Item46: 스트림에서는 부작용 없는 함수를 사용하라.](src/main/java/org/developx/effective_java/part7/item46)
```text
- foreach 연산은 병렬화 할 수 없는 반복문이라 계산하는데 사용하지 말자 (이것만 썼던것 같은데)
- 수집기(collector) 사용에 익숙해지자. (toList, toSet, toMap, groupingBy, joining)
```

- [Item47: 반환 타입으로는 스트림보다 컬렉션이 낫다.](src/main/java/org/developx/effective_java/part7/item47)
```text
- 원소 시퀀스를 반환하는 메서드를 작성할 때, 컬렉션을 반환하도록 하자. (stream 인터페이스가 Iterable을 지원하지 않음)
- Collection 인터페이스는 Iterable의 하위 타입이고, stream 메서드도 제공하니 둘다 제공하기 때문.
```

- [Item48: 스트림 병렬화는 주의해서 적용하라.](src/main/java/org/developx/effective_java/part7/item48)
```text
- 스트림 병렬화는 오직 성능 최적화 수단이다. 하지만 확신없이 사용하지 마라.
```

## 8장 메서드
- [Item49: 매개변수가 유효한지 검사하라.](src/main/java/org/developx/effective_java/part8/item49)
```text
- 메서드는 최대한 범용적으로 설계해야 한다. 메서드가 건네받은 값으로 제대로 동작할 수 있다면, 매개변수 제약은 적을수록 좋다.
- 매개변수들에 어떤 제약이 있을지 생각해야 하며, 그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야 한다.
```

- [Item50: 적시에 방어적 복사본을 만들라.](src/main/java/org/developx/effective_java/part8/item50)
```text
- java.util.Date 는 가변이고 낡은 API 이니 새로운 코드 작성시에 Instant, LocalDateTime, ZonedDateTime 등을 사용하자.
- 가변 매개변수의 경우 방어적 복사를 통해 값을 변경할 수 없도록 하자.
```

- [Item51: 메서드 시그니처를 신중히 설계하라.](src/main/java/org/developx/effective_java/part8/item51)
```text
- 메서드 이름을 신중이 짓자 (이게 제일 어렵다고..)
- 편의 메서드를 너무 많이 만들지 말자 
- 매개변수 목록은 짥게 유지하자 (4개 이하)
- 매개변수 타입은 최대한 추상화(interface) 하자
- boolean 보다는 원소 2개짜리 enum을 사용하자
```

- Item52: 다중정의는 신중히 사용하라.
```text
- API 사용자가 매개변수를 넘길 때, 어떤 다중정의 메서드가 호출될지 모른다면 프로그램은 오작동하기 쉽다.
- 다중정의시, 서로 다른 함수형 인터페이스 사용하지 말자 (ExecutorService.submit)
- 안전하고 보수적으로 가려면 매개변수 수가 같은 다중정의는 만들지 말자.
- 가변 인수를 매개변수로 사용한다면 다중정의는 사용하면 안 된다.
```

- [Item53: 가변인수는 신중히 사용하라.](src/main/java/org/developx/effective_java/part8/item53)
```text
- 인수 개수가 일정하지 않은 메서드를 정의시에 가변인수 사용하자.
- 필수 매개변수는 가변인수 앞에 두고, 성능문제를 고민하자.
```

- Item54: null이 아닌, 빈 컬렉션이나 배열을 반환하라.
 ```text
- null을 반환하는 API는 사용하기 어렵고, 오류처리 코드도 늘어난다. 
- 성능도 좋은 것도 아니다. (가능하다면 불변 컬렉션을 반환하라 : Collections.emptyList)
```

- Item55: 옵셔널 반환은 신중히 하라.
```text
- Optional 반환하는 메서드에서는 절대 null을 반환하지 마라.
- 기본값을 미리 만드는 orElse 보다, 값이 필요할때 호출되는 orElseGet(Supplier<T>) 를 활용하자
- 컬렉션, 스트림, 배열 같은 컨테이너 타입은 optional로 감싸면 안된다.
- Optional 의 항상 비용이 든다는 것을 감안하고 사용하자. 
```


## 9장 일반적인 프로그램밍 원칙
> 지역변수, 제어구조, 라이브러리, 데이터 타입, 리플렉션, 네이티브 메서드

- Item57: 지역변수의 범위를 최소화하라.
```text
- 지역 변수는 가장 처음 쓰일 때 선언하면서 초기화하자.
- 메서드를 작게 유지하고 한 가지 기능에 집중하자.
```

- Item58: 전통적인 for 문보다는 for-each 문을 사용하라.
```text
- for-each 문은 Iterable 인터페이스를 구현한 객체여야 한다.
- for 문보다는 for-each(enhanced fo statement) 문 사용을 고려하자.
```

- Item58: 라이브러리를 익히고 사용하라.
```text
- 최소한 java.lang, java.util, java.io 의 패키지에 있는 API는 공부하라.
- java.util.Random은 사용하지 말자 (TreadLocalRandom, SplittableRandom-병렬스트림)
```

- [Item59: 정확한 답이 필요하다면 float와 double은 피하라.](src/main/java/org/developx/effective_java/part9/item59)
```text
- double, float는 부동소수점을 빠르게 계산하기 위한 것이지 정확성을 가지지 못했다.
- 정확한 금액은 BigDecimal(성능이슈), 정수형(소수점 처리X) 로 하자.
```

- Item60: 박싱된 기본 타입보다는 기본 타입을 사용하라.
```text
- 가능하면 기본타입(int, long, double)을 사용하자.
- 박싱된 데이터는 == 연산자로 비교하면 식별성 비교가 발생하면서 제대로 비교되지 않는다. 
- 기본타입과 박싱된 기본 타입을 연산시에 언방싱이 발생하니 주의하자.
```

- Item61: 다른 타입 적절하다면 문자열 사용을 피하라.
```text
- 기본타입, 열거타입, 혼합타입등을 문자열로 대체하지 말자.
- 문자열을 사용하기 전에 더 적합한 데이터 타입을 확인해보자.
```

- Item62: 문자열 연결은 느리니 주의하라.
```text
- StringBuilder, StringBuffer(멀티쓰레드환경) 을 활용하여 문자열 연결을 하자.
- java 6부터 문자열 연결 성능을 개선했지만, 단순 연결이 아닌 경우에는 성능차이가 존재한다. (반복문인 경우 + 할때마다 StringBuilder 생성됨)
```

- Item63: 객체는 인터페이스를 사용해 참조하라.
```text
- 적합한 인터페이스만 있다면 매개변수뿐 아니라 반환값, 변수, 필드를 전부 인터페이스 타입으로 선언하라.
- 없다면 클래스의 계층구조 중 필요한 기능을 만족하는 가장 덜 구체적인 상위 클래스를 타입으로 사용하자.
```

- Item64: 리플렉션보다는 인터페이스를 사용하라.
```text
- 컴파일타임 타입 검사가 주는 이점을 하나도 누릴수 없다.
- 코드가 지저분해지고 성능이 떨어진다.
- 컴파일 타임에 알 수 없는 클래스를 사용하는 경우에만 리플렉션을 사용하자 
```

- Item66: 최적화는 신중히 하라
```text
- 빠른 프로그램보다는 좋은 프로그램을 작성하라.
- 단 API, 네트워크 프로토콜, 영구 저장용 데이터 포맷을 설계시에는 성능을 염두하자.
```

- [Item68: 일반적으로 통용되는 명명 규칙을 따르라.](src/main/java/org/developx/effective_java/part9/item68)
```text
- 자바의 명명규칙을 인지하고 잘 따르도록 하자.
```


## 10장 예외

- Item69: 예외는 진짜 예외 상황에만 사용하라.
```text
- 일상적인 제어 흐름용으로 쓰여서는 안된다.
- 클라이언트가 정상적인 제어 흐름에서 예외를 사용할 일이 없게 해야 한다.
```

- Item70: 복구할 수 있는 상황에는 검사 예외를 프로그래밍 오류에는 런타임 예외를 사용하라.
```text
- 복구할 수 있는 상황이면 검사예외 발생시키고, 복구에 필요한 정보를 알려주는 메서드도 제공하자.
- 프로그래밍 오류거나 확실하지 않다면 비검사 예외를 던지자.
- 검사 예외, 런타임 예외도 아닌 throwable 은 사용하지 말자.(시스템오류)
```

- Item71: 필요 없는 검사 예외 사용은 피하라.
```text
- API 호출자가 예외 상황에서 복구할 방법이 없다면 비검사 예외를 던지자.
- 복구 가능하고 호출자가 드 처리를 해주길 바란다면, Optional 반환 가능성을 먼저 확인하자.
```

- [Item72: 표준 예외를 사용하라.](src/main/java/org/developx/effective_java/part10/item72)
```text
- Exception, RuntimeException, Throwable, Error는 직접 재사용 하지 말자.
- 인수 값이 무엇이었든 어자피 실패했을 때는 IlleagalStateException 그렇지 않으면 IlleagalArgumentException을 던지자
```
 
- [Item73: 추상화 수준에 맞는 예외를 던지라.](src/main/java/org/developx/effective_java/part10/item73)
```text
- 아래 계층의 예외를 스스로 처리할 수 없고, 상위 계층에 그대로 노출하기 곤란하다면 예외 번역을 사용하라.
- 예외 연쇄를 사용하면 상위 계층에는 맥락에 어울리는 고수준 예외를 던지면서 근본 원인도 알려줄 수 있다.
```

- Item74: 메서드 던지는 모든 예외를 문서화하라.
```text
- 검사, 비검사 예외 모두 @throws 태그를 사용하여 문서화하라.
- 검사예외는 메서드 선언시 throws 문에 같이 선언하라
```

- Item75: 예외의 상세 메시지에 실패 관련 정보를 담으라.
```text
- 예외의 상세 메시지와 최종 사용자에게 보여줄 오류 메시지를 혼동해서는 안된다.
- 가독성보다는 담긴 내용이 중요하다. (표준화 없어도 된다.)
```

- Item76: 가능한 실패 원자적으로 만들라.
```text
- 호출된 메서드가 실패하더라도 해당 객체는 메서드 호출 전 상태를 유지해야 한다. 
- 불변의 객체로 생성하거나, 작업 수행에 앞서 유효성 검사 또는 임시 복사본에서 작업후 완료되면 값을 복사하는 방법.
```

- Item77: 예외를 무시하지 말라.
```text
- catch 블록을 비어두면 예외가 존재할 이유가 없어진다.
- 만약 무시한다면 블럭안에 주석으로 사유를 적고, 예외변수 이름도 ignored 로 변경하자.
```


## 11장 동시성 

- [Item78: 공유 중인 가변 데이터는 동기화해서 사용하라.](src/main/java/org/developx/effective_java/part11/item78)
```text
- 여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화해야 한다. 
> 배타적 실행은 필요 없고 스레드 끼리의 통신만 필요하다면 volatile 한정자만으로 동기화는 가능하다. (하지만 원자성은 보장 X)
> AtomicLong, AtomicInteger 등을 사용해서 원자성까지 보존할 수 있다.
```

- [Item79: 과도화 동기화는 피하라.](src/main/java/org/developx/effective_java/part11/item79)
```text
- 동기화 영역에서는 가능한 일을 적게 해야 한다.
- 자바의 동시성 컬렉션 라이브러리를 사용하자. (java.util.concurrent)
```

- [Item80: 스레드보다 실행자, 태스크, 스트림을 애용하라.](https://github.com/kim-taehan/java-study/blob/main/src/test/java/org/developx/javastudy/concurrency/README.md)
```text
- Thread와 Runnable
- Callable, Future 및 Executor
- CompletableFuture
```

- [Item81: wait와 notify보다는 동시성 유틸리티를 애용하라.](src/main/java/org/developx/effective_java/part11/item81)
```text
- java.concurrent 고수준 유틸리티는 실행자 프레임워크, 동시성 컬렉션, 동기화 장치로 분류된다. 
- 동시성 컬렉션: List, Queue, Map 같은 표준 컬렉션 인터페이스에 동시성을 가미해 구현한 고성능 컬렉션이다
- 동기화 장치: 스레드가 다른 스레드를 기다릴 수 있게 하여, 서로 작업을 조율할 수 있게 해준다. (CountDownLatch, Semaphore, Phaser)
```

- [Item82: 스레드 안전성 수준을 문서화 하라.](src/main/java/org/developx/effective_java/part11/item82)
```text
- 불변, 무조건적 스레드 안전, 조건부 스레드 안전, 스레드 안전하지 않음, 스레드 적대적 
- 무조건적 스레드 안전 클래스 작성시에는 synchronized 메서드가 아닌 비공개 락 객체를 사용하자.
```

- [Item83: 지연 초기화는 신중히 사용하라.](src/main/java/org/developx/effective_java/part11/item83)
```text
- 대부분의 상황에서 일반적인 초기화가 지연 초기화보다 낫다. 
- 인스턴스 필드에 이중검사 관용구 방법.
- 정적 필드에는 지연 초기화 홀더 클래스를 사용하자.
```