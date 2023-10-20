# effective java 3E 독후감
> 전체 글 정리는 아니고, 개인적으로 인지하고 있는 내용은 배제함 (시간 아까움)

## 2. 객체 생성과 파괴
> 객체를 만들어야 할 때와 만들지 말아야 할 때를 구분하는 법, 올바르게 객체 생성 방법과 불필요한 생성을 피하는 방법
- [Item1: 생성자 대신 정적 팩토리 매서드를 고려하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem1)
- [Item2: 생성자에 매개변수가 많다면 빌더를 고려하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem2)
- [Item3: private 생성자나 열거 타입으로 싱글턴임을 보증하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem3)
- [Item4: 인스턴스화를 막으려거든 private 생성자를 사용하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem4)
- [Item5: 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem5)
- [Item6: 불필요한 객체 생성을 피하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem6)
- [Item7: 다 쓴 객체 참조를 해제해라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem7)
- [Item8: finalizer와 cleaner 사용을 피하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem8)
- [Item9: try-finally보다 try-with-resources를 사용하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart2%2Fitem9)


## 3장 모든 객체의 공통 메서드
> Object 에서 final 이 아닌 메서드를 언제 어떻게 재정의 해야 되는지 설명  
> 참고 final 이 아닌 메서드: equals, hashCode, toString, clone, finalize

- [Item10: equals는 일반 규약을 지켜 재정의하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem10)
- [Item11: equals을 재정의하려거든 hashCode 도 재정의하라](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem11)
- [Item12: toString을 항상 재정의하라](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem12)
- [Item13: clone 재정의는 주의해서 진행하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem13)
- [Item14: Comparable 을 구현할지 고려하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem14)

## 4장 클래스와 인터페이스 
> 클래스와 인터페이스를 쓰기 편하고, 견고하며, 유연하게 만드는 방법

- [Item15: 클래스와 멤버의 접근 권한을 최소화하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem15)
```text
- 모든 클래스와 멤버의 접근성을 가능한 좁히자. 
- package-private (이 접근제어자 사용도 고려)
- 배열, Collection 멤버는 불변리스트 만들어서 넘기던가 복사본을 넘기는 방식으로 진행
- 단순한 vo 객체의 경우 record 객체 생성을 고려
```
- [Item16: public 클래스에서 public 필드가 아닌 접근자 메서드를 사용하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem16)
```text
- public 클래스에서 가변 필드를 직접 노출하해서 안된다 (불변필드도 조심)
- package 클래스나 중첩 private 클래스에서는 노출해도 큰 문제가 없다.
```

- [Item17: 변경 가능성을 최소화하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem17)
```text
- 클래스는 꼭 필요한 경우가 아니라면 불변이어야 한다.
- 성능 때문에 어쩔 수 없다면 불변 클래스와 함께 가변 동반 클래스를 public 클래스로 제공하도록 하자.
- 불변으로 만들 수 없는 클래스라도 변경할 수 있는 부분을 최소한으로 줄이도록 하자.
- 한번 만들어진 불변객체는 재활용할 수 있게 상수로 제공하자 (쓰레드 safe)
```

- [Item18: 상속보다는 컴포지션을 사용하라](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem18)
```text
- 여기서 상속(extends) 와 구현(implements)을 의미하는 것은 아니다.
- private 필드로 기존 클래스의 인스턴스를 참조하게하는 컴포지션 방식
```

- [Item19: 상속을 고려해 설계하고 문서화하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart4%2Fitem19)
```text
- 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지(자기사용) 문서로 남겨야 한다. 
- 좋은 API 문서란 '어떻게'가 아닌 '무엇'을 하는지를 설명 (@implSpec)
- 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안 된다.
```
