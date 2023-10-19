package org.developx.effective_java.part2.item2;

import org.developx.effective_java.part2.item2.basic.Email;
import org.developx.effective_java.part2.item2.hierarchy.EmailTemplate;
import org.developx.effective_java.part2.item2.hierarchy.Gmail;
import org.developx.effective_java.part2.item2.hierarchy.NaverMail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[item2] 생성자에 매개변수가 많다면 빌더를 고려하라")
class Item2Test {

    @DisplayName("필수,선택 매개변수를 구분하여 빌더패턴으로 생성한다.")
    @Test
    void emailBuilderTest(){

        LocalDate testDate = LocalDate.of(2023, 1, 1);
        Email email = new Email.Builder("kimtaehan", Email.MailType.GMAIL)
                .name("김태한")
                .createdDate(testDate)
                .build();

        assertThat(email)
                .extracting("address", "mailType", "name", "createdDate", "agreeMarketing")
                .contains("kimtaehan", Email.MailType.GMAIL, "김태한", testDate, false);
    }

    @DisplayName("계층적인 생성자로 gamil 정보를 생성한다.")
    @Test
    void gmailTest(){

        // given
        EmailTemplate emailTemplate = new Gmail.Builder()
                .address("kimtaehan")
                .name("김태한")
                .build();

        assertThat(emailTemplate)
                .extracting("address", "mailType", "name")
                .contains("kimtaehan", EmailTemplate.MailType.GMAIL, "김태한");
    }

    @DisplayName("계층적인 생성자로 naver mail 정보를 생성한다.")
    @Test
    void naverMailTest(){

        LocalDate testDate = LocalDate.of(2023, 1, 1);
        // given
        EmailTemplate emailTemplate = new NaverMail.Builder()
                .address("kimtaehan")
                .localDate(testDate)
                .build();

        assertThat(emailTemplate)
                .extracting("address", "mailType", "localDate", "agreeMarketing")
                .contains("kimtaehan", EmailTemplate.MailType.NAVER, testDate, false);
    }

}