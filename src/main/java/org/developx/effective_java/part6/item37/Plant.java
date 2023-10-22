package org.developx.effective_java.part6.item37;

public class Plant {

    enum LifeCycle {
        ANNUAL, PERNNIAL, BIENNIAL
    }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}