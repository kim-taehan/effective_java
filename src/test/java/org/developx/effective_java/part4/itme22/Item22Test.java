package org.developx.effective_java.part4.itme22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[Item22] 인터페이스는 타입을 정의하는 용도로만 사용하라.")
class Item22Test {

    @DisplayName("지름으로 원의 둘레를 구해보자.")
    @Test
    void calculatorCircleRound(){

        final int diameter = 10;
        double round = diameter * PieConstants.PIE;

        assertThat(round).isEqualTo(31.415_926_535_89);
    }
}