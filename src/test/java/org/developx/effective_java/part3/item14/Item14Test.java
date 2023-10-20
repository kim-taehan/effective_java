package org.developx.effective_java.part3.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Comparable 을 구현할지 고려하라.")
class Item14Test {

    @DisplayName("간단한 클래스의 compareTo 기능을 확인한다.")
    @Test
    void CaseInsensitiveStringTest(){
        CaseInsensitiveString aaaa = new CaseInsensitiveString("aaaa");
        CaseInsensitiveString bbbb = new CaseInsensitiveString("bbbb");

        System.out.println("" + aaaa.compareTo(bbbb));
        System.out.println("" + bbbb.compareTo(bbbb));
        System.out.println("" + bbbb.compareTo(aaaa));

        assertThat(aaaa.compareTo(bbbb)).isNotPositive();
        assertThat(bbbb.compareTo(aaaa)).isPositive();
    }

    @DisplayName("비교해야 되는 유형이 다수인 경우 프로세스")
    @Test
    void PhoneNumberTest(){

        PhoneNumber phoneNumber1 = new PhoneNumber(10, 10L, 10.0D);
        PhoneNumber phoneNumber2 = new PhoneNumber(10, 11L, 10.0D);
        PhoneNumber phoneNumber3 = new PhoneNumber(10, 11L, 12.0D);


        assertThat(phoneNumber1.compareTo(phoneNumber2)).isNotPositive();
        assertThat(phoneNumber3.compareTo(phoneNumber2)).isPositive();
        assertThat(phoneNumber1.compareTo(phoneNumber3)).isNotPositive();
    }

}