package org.developx.effective_java.part1.item2.hierarchy;

import lombok.Getter;

@Getter
public class Gmail extends EmailTemplate {

    private final String name;

    public static class Builder extends EmailTemplate.Builder<Builder> {

        private String name;

        @Override
        protected Builder self() {
            this.mailType = MailType.GMAIL;
            return this;
        }

        @Override
        public EmailTemplate build() {
            return new Gmail(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }

    protected Gmail(Builder builder) {
        super(builder);
        this.name = builder.name;
    }
}
