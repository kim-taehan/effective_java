package org.developx.effective_java.part2.item9;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public class StreamReader<T> implements AutoCloseable {
    private final Stream<T> stream;
    public StreamReader(Stream<T> stream) {
        this.stream = stream;
    }
    @Override
    public void close() throws IllegalAccessError {
        System.out.println("close method call");
        stream.close();
    }
}
