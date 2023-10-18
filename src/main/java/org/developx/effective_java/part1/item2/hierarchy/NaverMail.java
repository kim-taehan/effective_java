package org.developx.effective_java.part1.item2.hierarchy;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NaverMail extends EmailTemplate {

    private final boolean agreeMarketing;
    private final LocalDate localDate;

    public static class Builder extends EmailTemplate.Builder<Builder> {

        private boolean agreeMarketing = false;
        private LocalDate localDate;

        @Override
        protected Builder self() {
            this.mailType = MailType.NAVER;
            return this;
        }

        @Override
        public EmailTemplate build() {
            return new NaverMail(this);
        }

        public Builder agreeMarketing(boolean agreeMarketing) {
            this.agreeMarketing = agreeMarketing;
            return this;
        }
        public Builder localDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }
    }

    protected NaverMail(Builder builder) {
        super(builder);
        this.agreeMarketing = builder.agreeMarketing;
        this.localDate = builder.localDate;
    }
}
