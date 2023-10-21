package org.developx.effective_java.part5.itme26;

import java.util.HashSet;
import java.util.Set;

public class UseUnknownElementRawTypeSample {

    static int numElementsInCommonWithLowType(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }



}
