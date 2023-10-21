package org.developx.effective_java.part4.item24;

public class StaticMemberClass {
    private final String name;

    public String getName() {
        return name;
    }

    private StaticMemberClass(String name) {
        this.name = name;
    }

    public static class Builder {
        private String name;
        public Builder(String name) {
            this.name = name;
        }
        public StaticMemberClass build() {
            return new StaticMemberClass(this.name);
        }
    }
}
