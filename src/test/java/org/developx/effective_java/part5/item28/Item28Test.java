package org.developx.effective_java.part5.item28;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Item28: 배열보다는 리스트를 사용하라.")
public class Item28Test {

    @DisplayName("배열의 경우 런타임시 애러가 발생한다.")
    @Test
    void arrayAnotherTypeTest(){
        Object[] objectArray = new Long[1];
        assertThatThrownBy(() -> objectArray[0] = "타입이 달라 넣을 수 없다.")
                .isInstanceOf(ArrayStoreException.class);
    }

    @DisplayName("배열의 경우 런타임시 애러가 발생한다.")
    @Test
    void ListAnotherTypeTest(){
//        List<Object> ol = new ArrayList<Long>(); // 컴파일시 애러를 확인
        System.out.println("TEST");
    }

    @DisplayName("제네릭 리스트를 활용한 예제")
    @Test
    void test46(){
        Chooser<Integer> chooserInt = new Chooser(List.of(10, 20));
        int chooseInt = chooserInt.choose();
        assertThat(chooseInt).isIn(10, 20);

        Chooser<String> chooserStr = new Chooser(List.of("10", "20"));
        String chooseStr = chooserStr.choose();
        assertThat(chooseStr).isIn("10", "20");
    }

}
