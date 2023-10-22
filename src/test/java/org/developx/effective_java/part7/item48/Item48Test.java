package org.developx.effective_java.part7.item48;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

@DisplayName("Item48: 스트림 병렬화는 주의해서 적용하라.")
public class Item48Test {

    @DisplayName("병렬로 pi 계산 : 19268")
    @Test
    void test44(){
        Instant start = Instant.now();
        piParallel(10000000);
        Instant end = Instant.now();
        System.out.println("수행시간: " + Duration.between(start, end).toMillis() + " ms");
    }

    @DisplayName("노병렬로 pi 계산 : 42274")
    @Test
    void test45(){
        Instant start = Instant.now();
        piNoParallel(10000000);
        Instant end = Instant.now();
        System.out.println("수행시간: " + Duration.between(start, end).toMillis() + " ms");
    }

    static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static long piNoParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

}
