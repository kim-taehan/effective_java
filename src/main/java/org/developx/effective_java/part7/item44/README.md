# 표준 함수형 인터페이스를 사용하라.

```text
[DO NOT]
- java.util.function 에 정의된 표준 함수형 인터페이스를 사용하자. (Supplier, Function, Consumer, Predicate)
- @FunctionalInterface 애너테이션으로 함수형 인터페이스 임을 알려라.
```


## 기본 함수형 인터페이스 정리
|인터페이스|함수 시그니처|사용예|
|--|--|--|
|UnaryOperator<T>|T apply(T t)|String::toLowerCase|
|BinaryOperator<T>|T apply(T t1, T t2)|BigInteger::add|
|Predicate<T>|boolean test(T t)|Collection::isEmpty|
|Function<T>|R apply(T t)|Arrays::asList|
|Supplier<T>|T get()|Instant::now|
|Consumer<T>|void accept(T t)|System.out::println|