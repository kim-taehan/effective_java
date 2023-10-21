package org.developx.effective_java.part5.item29;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;


class Item29Test {
    @DisplayName("제너릭으로 만든 Stack 테스트")
    @Test
    void stackTest(){
        Stack<String> stringStack = new Stack<>();
        stringStack.push("hello");
        stringStack.push("kimtaehan");
        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }
}