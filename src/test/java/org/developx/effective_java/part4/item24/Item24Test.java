package org.developx.effective_java.part4.item24;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Item24: 멤버 클래스는 되도록 static으로 만들라.")
class Item24Test {

    @DisplayName("정적 멤버 클래스로 빌더 패턴 구현")
    @Test
    void StaticMemberClassTest(){
        StaticMemberClass clazz = new StaticMemberClass.Builder("TEST").build();
        assertThat(clazz.getName()).isEqualTo("TEST");
    }

    @DisplayName("비정적 맴버 EntrySet 확인하기")
    @Test
    void memberClassTest() {
        Map<String, String> map = new HashMap<>();
        map.put("key01", "value01");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }
    }

    @DisplayName("익명 클래스 활용하기")
    @Test
    void anonymousTest() {
        TestClass testClass = new TestClass();
        testClass.anonymous();
    }
    @DisplayName("지역 클래스 활용하기")
    @Test
    void localClassTest() {
        TestClass testClass = new TestClass();
        testClass.local();
    }
    
}