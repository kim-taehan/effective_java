package org.developx.effective_java.part1.item8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public static Runnable Trash = () -> System.out.println("휴지통을 청소합니다.");

    public Room() {
        cleanable = cleaner.register(this, Trash);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}
