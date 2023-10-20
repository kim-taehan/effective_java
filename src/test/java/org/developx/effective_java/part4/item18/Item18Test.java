package org.developx.effective_java.part4.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[itme18] 상속보다는 컴포지션을 사용하라.")
class Item18Test {

    @DisplayName("컴포지션을 통해서 getCount 기능을 테스트한다.")
    @Test
    void getCountTest(){
        CustomSet<String> customSet = new CustomSet<>(new HashSet<>());
        customSet.add("apple");
        customSet.add("banana");

        assertThat(customSet.getCount()).isEqualTo(2);
    }
}