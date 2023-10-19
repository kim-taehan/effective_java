package org.developx.effective_java.part1.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[item6] 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라")
public class Item6Test {
    @DisplayName("String 하나의 객체를 재사용 하자.")
    @Test
    void createStringTest(){
        assertThat(new String("test"))
                .isNotSameAs(new String("test"));

        assertThat("test")
                .isSameAs("test");
    }

    @DisplayName("정적 팩터리를 제공하는 불변 클래스를 활용하자")
    @Test
    void fixEntityTest(){
        assertThat(Boolean.valueOf(true))
                .isSameAs(Boolean.TRUE);
    }

    @DisplayName("값비싼 객체를 재사용해 성능을 개선한다.")
    @Test
    void expensiveObjectsTest(){
        assertThat(RomanNumerals.isRomanNumeral("IIO"))
                .isFalse();

        assertThat(RomanNumerals.isRomanNumeral("III"))
                .isTrue();

    }
}
