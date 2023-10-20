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

- [Item15: 클래스와 멤버의 접근 권한을 최소화하라.](src%2Fmain%2Fjava%2Forg%2Fdevelopx%2Feffective_java%2Fpart3%2Fitem15)
```text
모든 클래스와 멤버의 접근성을 가능한 좁히자. 
package-private (이 접근제어자 사용도 고려)
배열, Collection 멤버는 불변리스트 만들어서 넘기던가 복사본을 넘기는 방식으로 진행
단순한 vo 객체의 경우 record 객체 생성을 고려
```


