package org.developx.effective_java.part2.item2.basic;

import java.time.LocalDate;

public record Email (
        // 필수
        String address,
        MailType mailType,
        
        // 선택
        String name,
        LocalDate createdDate,
        boolean agreeMarketing
) {
    public static enum MailType {
        GMAIL, NAVER;
    }
    public static class Builder {

        private final String address;
        private final MailType mailType;

        // 선택
        private String name = "";
        private LocalDate createdDate;
        private boolean agreeMarketing = false;

        public Builder(String address, MailType mailType) {
            this.address = address;
            this.mailType = mailType;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }
        public Builder agreeMarketing(boolean agreeMarketing) {
            this.agreeMarketing = agreeMarketing;
            return this;
        }

        public Email build() {
            return new Email(
                    this.address,
                    this.mailType,
                    this.name,
                    this.createdDate,
                    this.agreeMarketing
            );
        }
    }
}
