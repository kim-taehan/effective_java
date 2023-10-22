package org.developx.effective_java.part7.item43;

import java.time.Instant;
import java.util.Map;

public class Item43 {
    // 람다보다는 메서드 참조를 사용하라.
    void methodReference() {
        Map<String, Integer> map = Map.of("1", 10, "2", 20, "3", 30, "4", 40);
        // 람다식 사용
        Integer mergeRamda = map.merge("1", 30, (count, incr) -> count + incr);
        // 메서드 참조
        Integer mergeReference = map.merge("1", 30, Integer::sum);
    }
}
