package org.developx.effective_java.part5.item32;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> ret = new ArrayList<>();
        for (List<? extends T> list : lists) {
            ret.addAll(list);
        }
        return ret;
    }
}
