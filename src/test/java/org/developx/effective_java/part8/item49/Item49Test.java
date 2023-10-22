package org.developx.effective_java.part8.item49;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Item49: 매개변수가 유효한지 검사하라.")
class Item49Test {

    @DisplayName("mod에서 매개변수는 양수가 아니면 애러가 발생한다.")
    @Test
    void test89(){
        Item49 item49 = new Item49();
        assertThatThrownBy(() -> item49.mod(BigInteger.ZERO))
                .isInstanceOf(ArithmeticException.class);
    }
    @DisplayName("Object.requireNonNull 에 null 데이터를 입력하면 안된다.")
    @Test
    void test82(){
        assertThatThrownBy(() -> Objects.requireNonNull(null, "널입니다."))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("널입니다.");
    }


}