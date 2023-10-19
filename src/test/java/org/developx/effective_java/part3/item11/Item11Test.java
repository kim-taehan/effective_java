package org.developx.effective_java.part3.item11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[item11] equals을 재정의하려거든 hashCode 도 재정의하라")
class Item11Test {

    @DisplayName("equals가 동일하면 hashcode 도 동일해야 한다.")
    @Test
    void hashcodeTest(){
        // given
        Item11 item1 = new Item11("kimtaehan", 30);
        Item11 item2 = new Item11("kimtaehan", 30);

        // when
        WeakHashMap<Item11, String> hashMap = new WeakHashMap<>();
        hashMap.put(item1, "test");

        // then
        assertThat(item1.hashCode()).isEqualTo(item2.hashCode());
        assertThat(hashMap.get(item2)).isEqualTo("test");


    }


}