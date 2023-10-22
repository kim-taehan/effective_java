package org.developx.effective_java.part6.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> transitionMap;

        static {
            transitionMap = Stream.of(values())
                    .collect(Collectors.groupingBy(t -> t.from, // 바깥 Map의 Key
                            () -> new EnumMap<>(Phase.class), // 바깥 Map의 구현체
                            Collectors.toMap(t -> t.to, // 바깥 Map의 Value(Map으로), 안쪽 Map의 Key
                                    t -> t, // 안쪽 Map의 Value
                                    (x,y) -> y, // 만약 Key값이 같은게 있으면 기존것을 사용할지 새로운 것을 사용할지
                                    () -> new EnumMap<>(Phase.class)))); // 안쪽 Map의 구현체
        }

        public static Transition from(Phase from, Phase to) {
            return transitionMap.get(from).get(to);
        }
    }
}