package org.developx.effective_java.part2.item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[item1] 생성자 대신 정적 팩토리 매서드를 고려하라")
class Item1Test {

    @DisplayName("장점1 이름을 가질 수 있다.")
    @Test
    void hasName(){
        // given
        final String emailFullName = "kimtaehan@gmail.com";

        // when
        Email email = Email.createByFullName(emailFullName);

        // then
        assertThat(email)
                .extracting("address", "domain")
                .contains("kimtaehan", MailType.GMAIL);
    }

    @DisplayName("장점2 매번 인스턴스를 생성하지 않아도 된다.")
    @Test
    void staticInstance(){
        // given
        final String emailFullName = "kimtaehan@gmail.com";
        Email customEmail = Email.createByFullName(emailFullName);

        // when
        Email adminEmail1 = Email.getAdminEmail();
        Email adminEmail2 = Email.getAdminEmail();

        // then
        assertThat(adminEmail1).isSameAs(adminEmail2);  // 완전 동일한 인스턴스
        assertThat(adminEmail1).isNotSameAs(customEmail); // 상태는 같지만 다른 인스턴스
    }

    @DisplayName("장점3 반환 타입의 하위 타입객체를 반환할 수 있다.")
    @Test
    void returnSubType(){
        // given
        // when
        Email subTypeEmail = Email.createGmail("kimtaehan");

        // then
        assertThat(subTypeEmail).isInstanceOf(Gmail.class);
    }

    @DisplayName("장점4 입력변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.")
    @Test
    void returnAnotherEntity(){
        // given
        // when
        Email naverMail = Email.createByFullName("kimtaehan@naver.com");
        Email gmail = Email.createByFullName("kimtaehan@gmail.com");

        // then
        assertThat(naverMail).isInstanceOf(NaverMail.class);
        assertThat(gmail).isInstanceOf(Gmail.class);
    }
}