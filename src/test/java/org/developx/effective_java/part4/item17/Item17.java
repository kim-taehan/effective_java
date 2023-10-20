package org.developx.effective_java.part4.item17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[item17] 변경 가능성을 최소화하라.")
class Item17 {
    @DisplayName("불변객체는 변하지 않는다.")
    @Test
    void test960(){
        // given
        Complex complex1 = new Complex(10D, 10D);
        Complex complex2 = new Complex(11D, 11D);
        // when
        Complex plus = complex1.plus(complex2);

        // then
        Assertions.assertThat(complex1).extracting("re", "im")
                .contains(10D, 10D);
    }


}