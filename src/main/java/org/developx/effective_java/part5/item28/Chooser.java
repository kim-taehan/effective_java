package org.developx.effective_java.part5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser <T> {
    private final List<T> choices;

    public Chooser(Collection<T> choices) {
        this.choices = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choices.get(rnd.nextInt(choices.size()));
    }
}
