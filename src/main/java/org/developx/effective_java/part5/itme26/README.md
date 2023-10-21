# - 로 타입은 사용하지 말라.
> 클래스와 인터페이스 선언에 타입 매개변수가 쓰이면 이를 제너릭 타입이라 한다. (제너릭 클래스, 제너릭 인터페이스)

```text
- 클래스와 인터페이스 선언에 타입 매개변수가 쓰이면 이를 제너릭 타입이라 한다. (제너릭 클래스, 제너릭 인터페이스)
- 로 타입(타입 매개변수가 없는 제너릭 타입) List, Collection -> List<String>, Collection<Integer>
```

## 로 타입 사용시 문제점
> List 를 사용시에 List에 원치 않은 데이터를 넣는 코드에서 컴파일 애러가 아닌 런타임 애러가 발생한다. 
```java
class test{
    // 로타입을 사용하지 않은 경우 
    final Collection<Stamp> stamps = new ArrayList<>();
    stamps.add(new Coin()); // 컴파일 애러가 발생한다.
}
```

## 비한정적 와일드카드 타입 사용
> Collection<?>에는 (null 외에는) 어떤 원소도 넣을 수 없다.   
> 다른 원소를 넣으려 하면 컴파일할 때 오류 메시지를 보게 된다.
```java
class test {
    void 사용금지(Set object) {
        object.add(100); // 컴파일 애러가 발생하지 않음
    }    
    
    void 비한정와일드카드(Set<?> object) {
        object.add(100); // 컴파일 애러가 발생하여 미리 확인 가능 
    }
    
}
```

## 용어 정리
|한글 용어|영문 용어|	예|
|--|--|--|
|매개변수화 타입|parameterized type|	List<String>|
|실제 타입 매개변수|actual type parameter|String|
|제네릭 타입|generic type|List<E>|
|정규 타입 매개변수|formal type parameter|E|
|비한정적 와일드카드 타입|	unbounded wildcard typ|	List<?>|
|로 타입|raw type|List|
|한정적 타입 매개변수|bounded type parameter|`<E extends Number>`|
|재귀적 타입 한정|recursive type bound|<T extends Comparable<T>>|
|한정적 와일드카드 타입|bounded wildcard type|List<? extends Number>|
|제네릭 메서드|generic method|`static <E> List<E> asList(E[] a)`|
|타입 토큰|type token|String.class|