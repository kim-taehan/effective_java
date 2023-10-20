package org.developx.effective_java.part4.item15;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[item15] 클래스와 멤버의 접근 권한을 최소화하라.")
class Item15Test {

    @DisplayName("접근제어자별로 접근가능 법위를 확인한다.")
    @Test
    void checkAccessControl(){
        // given
        AccessControl accessControl = new AccessControl("kimtaehan");
        String text = accessControl._public();
        String text2 = accessControl._packagePrivate();
        assertThat(text).isEqualTo(text2);
    }

    @DisplayName("static final array 복사본 수정 후 기존 변수 체크")
    @Test
    void checkCopyArray(){
        // given
        String[] copyData = AccessControl.getVALUES();
        copyData[0] = null;
        copyData[1] = null;
        String[] copayDate2 = AccessControl.getVALUES();
        assertThat(copayDate2).hasSize(2)
                .contains("apple", "banana");
    }

    @DisplayName("immutability collection에 데이터 추가시 오류가 발생한다.")
    @Test
    void checkimmutabilityCollection(){
        // given
        List<String> valuesList = AccessControl.VALUES_LIST;

        // 불변객첵에 추가하는 경우 애러가 발생한다.
        Assertions.assertThatThrownBy(() -> valuesList.add("test"))
                .isInstanceOf(UnsupportedOperationException.class);

    }
}