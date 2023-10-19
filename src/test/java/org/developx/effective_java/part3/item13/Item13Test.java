package org.developx.effective_java.part3.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[Item13] clone 재정의는 주의해서 진행하라.")
class Item13Test {

    @DisplayName("가변상태를 참조하는 클래스용 clone 메서드")
    @Test
    void cloneTest(){
        // given
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        // when

        Stack clone = stack.clone();
        stack.push("4");
        // then
        assertThat(clone.pop()).isEqualTo("3");
        assertThat(stack.pop()).isEqualTo("4");
    }

}