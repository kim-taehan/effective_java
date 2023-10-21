package org.developx.effective_java.part5.item30;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("이왕이면 제네릭 메서드로 만들라.")
class Item30Test {

    @DisplayName("제너릭 메서드 테스트")
    @Test
    void genericMethodTest(){
        Set<String> union = Utils.union(Set.of("1", "2"), Set.of("3", "4", "5"));
        assertThat(union).contains("1", "2", "3", "4", "5");
    }

    @DisplayName("제너리 싱글턴 팩터리 테스트")
    @Test
    void genericSingletonFactoryTest(){
        Set<String> emptySet = Collections.emptySet();
        assertThat(emptySet).isNotNull().isEmpty();
    }

    @DisplayName("재귀적 타입 한정 테스트")
    @Test
    void test457(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(333);
        list.add(2222);
        list.add(1112);

        assertThat(Utils.max(list))
                .isEqualTo(2222);
    }


}