package org.developx.effective_java.part1.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

@DisplayName("[item7] 다 쓴 객체 참조를 해제해라.")
class Item7Test {

    @DisplayName("외부에서 키를 참조하는 동안만 엔트리가 살아 있는 캐시인 경우 사용 가능")
    @Test
    void weakHashMapTest(){
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key1 = 1000;
        Integer key2 = 2000;

        map.put(key1, "홍길동");
        map.put(key2, "류관순");
        key1 = null;

        System.gc();
        map.entrySet().stream().forEach(m -> System.out.println(m));
    }
}