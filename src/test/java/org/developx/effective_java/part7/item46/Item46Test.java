package org.developx.effective_java.part7.item46;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.developx.effective_java.part7.item46.Item46.FREQ;

@DisplayName("스트림에서는 부작용 없는 함수를 사용하라.")
class Item46Test {

    @DisplayName("stream을 활용해 빈도표를 초기화 한다.")
    @Test
    void groupingByTest(){
        Map<String, Long> collect = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));
        System.out.println(collect);
    }
    @DisplayName("빈도표에서 가장 많은 3개를 뽑아낸다.")
    @Test
    void top3Test(){
        Map<String, Long> freq = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));

        List<String> collect = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(3)
                .collect(Collectors.toList());

        assertThat(collect).contains("green", "black", "white");
    }
    @DisplayName("toMap 수집기를 사용하여 Map에 맵핑해보자.")
    @Test
    void toMapTest(){
        Map<String, Long> freq = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));


        Map<Long, String> collect = freq.keySet().stream()
                .collect(toMap(freq::get, e -> e));

        System.out.println(collect);
    }

    @DisplayName("흰색과 흰색이 아닌 그룹화")
    @Test
    void test485(){
        Map<String, List<String>> collect = FREQ.stream()
                .collect(groupingBy(word -> word.equals("white") ? "true" : "false"));

        System.out.println(collect);
    }
}