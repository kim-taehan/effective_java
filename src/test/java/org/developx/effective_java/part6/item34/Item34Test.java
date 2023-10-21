package org.developx.effective_java.part6.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("int 상수 대신 열거 타입을 사용하라.")
class Item34Test {

   @DisplayName("각 행성에 중력에 무게를 측정한다.")
   @Test
   void test3(){
       double earthWeight = 10D;
       double mass = earthWeight / Planet.EARTH.surfaceGravity();
       for (Planet p : Planet.values()){
           System.out.printf("%s에서의 무게는 %f이다.%n", p, p.surfaceWeight(mass));
       }
   }

   @DisplayName("사칙연산을 열거타입을 통해 수행한다.")
   @Test
   void test227(){
       assertThat(Operation.DIVIDE.apply(10, 2)).isEqualTo(5);
       assertThat(Operation.PLUS.apply(10, 2)).isEqualTo(12);
       assertThat(Operation.MINUS.apply(10, 2)).isEqualTo(8);
       assertThat(Operation.TIMES.apply(10, 2)).isEqualTo(20);
   }


}