package org.developx.effective_java.part11.item83;

import java.util.UUID;

public class DoubleCheckLazyInit {

    private volatile String field;

    private String getField() {
        String result = field;
        if (result != null) {
            return result;
        }
        synchronized (this) {
            if (field == null) {
                field =  computeFileValue();
            }
            return field;
        }
    }

    private String computeFileValue() {
        return UUID.randomUUID().toString();
    }
}
