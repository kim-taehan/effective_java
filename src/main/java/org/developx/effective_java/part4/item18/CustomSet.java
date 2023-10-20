package org.developx.effective_java.part4.item18;

import java.util.Collection;
import java.util.Set;

public class CustomSet<E> extends ForwardingSet<E> {
    public CustomSet(Set<E> set) {
        super(set);
        count = 0;
    }

    private int count;
    public int getCount() {
        return count;
    }

    @Override
    public boolean add(E o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }
}
