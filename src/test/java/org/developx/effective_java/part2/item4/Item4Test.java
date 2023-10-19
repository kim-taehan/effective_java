package org.developx.effective_java.part2.item4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[item4] 인스턴스화를 막으려거든 private 생성자를 사용하라")
class Item4Test {

    @DisplayName("java 리플렉션으로 인스터스 얻어올때 애러가 발생한다.")
    @Test
    void reflectionTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // given
        Constructor<UtilityClass> constructor = (Constructor<UtilityClass>) UtilityClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThatThrownBy(() -> constructor.newInstance()).isInstanceOf(InvocationTargetException.class);
    }
}