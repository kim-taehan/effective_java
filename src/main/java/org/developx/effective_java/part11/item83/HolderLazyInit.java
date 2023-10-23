package org.developx.effective_java.part11.item83;

import java.util.UUID;

public class HolderLazyInit {
    private static String field;

    public static String getField() {
        return FieldHolder.field;
    }

    private static class FieldHolder {
        static final String field = computeField();
    }
    private static String computeField() {
        return UUID.randomUUID().toString();
    }
}
