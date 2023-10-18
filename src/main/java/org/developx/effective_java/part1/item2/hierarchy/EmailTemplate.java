package org.developx.effective_java.part1.item2.hierarchy;

import lombok.Getter;

@Getter
public abstract class EmailTemplate {

    private final String address;
    private final MailType mailType;
    public enum MailType {
        GMAIL, NAVER;
    }

    abstract static class Builder<T extends Builder<T>>{
        private String address;
        protected MailType mailType;

        public T address(String address) {
            this.address = address;
            return self();
        }

        protected abstract T self();

        abstract EmailTemplate build();
    }

    protected EmailTemplate(Builder<?> builder) {
        this.address = builder.address;
        this.mailType = builder.mailType;
    }
}
