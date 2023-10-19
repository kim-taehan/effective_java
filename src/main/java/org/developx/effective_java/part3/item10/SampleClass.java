package org.developx.effective_java.part3.item10;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
public class SampleClass {

    private final int basic;
    private final String reference;
    private final double _double;
    private final String[] strings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleClass that = (SampleClass) o;
        return basic == that.basic
                && Double.compare(that._double, _double) == 0
                && Objects.equals(reference, that.reference)
                && Arrays.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(basic, reference, _double);
        result = 31 * result + Arrays.hashCode(strings);
        return result;
    }
}
