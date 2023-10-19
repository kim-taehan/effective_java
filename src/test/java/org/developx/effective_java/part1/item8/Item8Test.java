package org.developx.effective_java.part1.item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[item8] finalizer와 cleaner 사용을 피하라")
class Item8Test {

    @DisplayName("AutoCloseable 인터페이스를 구현하고, 인스터스를 다쓰고 나면 close 메서드 직접 호출")
    @Test
    void autoCloseableTest() throws Exception {
        Room room = new Room();
        System.out.println("Room 인스턴스 사용");
        room.close();
    }

    @DisplayName("try-with-resources 에서 자동으로 호출")
    @Test
    void trywithTest() {
        try (Room room = new Room()) {
            System.out.println("Room 인스턴스 사용");
        }
    }
}