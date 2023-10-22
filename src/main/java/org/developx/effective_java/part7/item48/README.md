# 스트림 병렬화는 주의해서 적용하라.

```text
[DO NOT]
- 스트림 병렬화는 오직 성능 최적화 수단이다.
```

## 자바의 동시성 프로그래밍
1. java 첫 릴리즈 부터 thread, 동기화, wait/notify를 지원하였다. 
2. 자바 5부터는 동시성 컬렉션은 java.util.concurrent 라이브러리와 Executor 프레임워크를 지원
3. 자바 7에서는 고성능 병렬 분해 프레임워크인 fork-join 패키지 추가
4. 자바 8부터는 parallel 메서드 한 번 호출하면 파이프라인을 병렬 실행할 수 있는 Stream 제공

## 참조 지역성이란? 
> 한번 참조한 데이터는 다시 참조될 가능성이 높고 참조된 데이터 주변의 데이터 역시 같이 참조될 가능성이 높은 성질이다.  
> ArrayList, HashMap, HashSet, ConcurrentHashMap의 인스턴스거나 배열, int 범위, long 이 사용하기 좋은 구조이다.


> (min, max, count, sum), anyMatch, allMatch, noneMatch처럼 조건에 맞으면 바로 반환되는 메서드도 병렬화에 적합

## 가변 축소 메서드란? 
> 결과값을 가공하여 새로운 리스트로 추출하는 메서드이다.   
> 가변 축소를 수행하는 Stream의 collect 메서드는 병렬화에 적합하지 않다.


```java
static long pi(long n) {
	return LongStream.rangeClosed(2, n)
		.parallel()
		.mapToObj(BigInteger::valueOf)
		.filter(i -> i.isProbablePrime(50))
		.count();
}
```