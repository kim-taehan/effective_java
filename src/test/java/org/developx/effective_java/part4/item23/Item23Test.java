package org.developx.effective_java.part4.item23;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item23: 태그 달린 클래스보다는 클래스 계층구조를 활용하라")
class Item23Test {

    @DisplayName("원형이 너비를 계산한다.")
    @Test
    void calculatorCircleArea(){
        Figure circle = new Circle(10);
        double area = circle.area();
        assertThat(area).isEqualTo(31.415_926_535_897_93);
    }
    @DisplayName("사각형 너비를 계산한다.")
    @Test
    void calculatorRectangleArea(){
        Figure rectangle = new Rectangle(10, 10);
        double area = rectangle.area();
        assertThat(area).isEqualTo(100);
    }

}