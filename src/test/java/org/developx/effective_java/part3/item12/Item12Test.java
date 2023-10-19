package org.developx.effective_java.part3.item12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Item12] toString을 항상 재정의하라")
class Item12Test {

    @DisplayName("toString 은 인지하기 쉽게 모든정보가 보인다.")
    @Test
    void toStringTest(){
        Mail gmail = new Mail("kimtaehan", Mail.MailType.GMAIL);
        Mail nMail = new Mail("test", Mail.MailType.NAVER);

        System.out.println(gmail); // MAIL{ kimtaehan@gmail.com }
        System.out.println(nMail); // MAIL{ test@naver.com }
    }
}