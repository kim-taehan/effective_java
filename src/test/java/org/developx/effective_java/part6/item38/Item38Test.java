package org.developx.effective_java.part6.item38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

@DisplayName("[Item38] 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라.")
class Item38Test {

    @DisplayName("확장 operation test")
    @Test
    void test514(){
        test(Arrays.asList(ExtendedOperation.values()), 4D, 2D);
    }

    private void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation operation : opSet) {
            System.out.println(operation.toString() + "=" + operation.apply(x, y));
        }
    }

}