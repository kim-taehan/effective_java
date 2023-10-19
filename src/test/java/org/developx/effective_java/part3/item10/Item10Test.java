package org.developx.effective_java.part3.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("equals는 일반 규약을 지켜 재정의하라.")
class Item10Test {

    @DisplayName("반사성 확인")
    @Test
    void reflexivityTest(){
        String[] strings = new String[]{"1", "2"};
        SampleClass object = new SampleClass(100, "kimtaehan", 100.2D, strings);
        assertThat(object.equals(object)).isTrue();
    }

    @DisplayName("대칭성 확인")
    @Test
    void symmetry(){
        String[] strings1 = new String[]{"1", "2"};
        String[] strings2 = new String[]{"1", "2"};
        SampleClass object1 = new SampleClass(100, "kimtaehan", 100.2D, strings1);
        SampleClass object2 = new SampleClass(100, "kimtaehan", 100.2D, strings2);
        assertThat(object1).isEqualTo(object2);
        assertThat(object2).isEqualTo(object1);
    }

    @DisplayName("추이성 확인")
    @Test
    void transitivityTest(){
        String[] strings = new String[]{"1", "2"};
        SampleClass object1 = new SampleClass(100, "kimtaehan", 100.2D, strings);
        SampleClass object2 = new SampleClass(100, "kimtaehan", 100.2D, strings);
        SampleClass object3 = new SampleClass(100, "kimtaehan", 100.2D, strings);
        assertThat(object1).isEqualTo(object2);
        assertThat(object2).isEqualTo(object3);
        assertThat(object3).isEqualTo(object1);
    }

    @DisplayName("null-아님 확인")
    @Test
    void nullTest(){
        String[] strings = new String[]{"1", "2"};
        SampleClass object1 = new SampleClass(100, "kimtaehan", 100.2D, strings);
        assertThat(object1).isNotEqualTo(null);
    }

}