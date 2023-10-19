package org.developx.effective_java.part2.item9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("t[item9] try-finally보다 try-with-resources를 사용하라")
class Item9Test {

    @DisplayName("try-with-resources 사용하게 안전하게 자원 종료.")
    @Test
    void resourcesTest(){
        List<String> strings = List.of("001", "002");
        try (StreamReader<String> readers = new StreamReader<>(strings.stream())) {
            readers.getStream().forEach(System.out::println);
        }
    }
}