package org.developx.effective_java.part5.item32;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("제너릭과 가변인수를 함께 쓸 때는 신중하라.")
class Item32Test {

    @DisplayName("제너릭 가변인수를 안전하게 사용하는 메서드")
    @Test
    void test10(){
        List<Integer> flatten = GenericVarargs.flatten(List.of(1), List.of(2));

        int sum = flatten.stream()
                .mapToInt(l -> l)
                .sum();
        assertThat(sum).isEqualTo(3);
    }



}