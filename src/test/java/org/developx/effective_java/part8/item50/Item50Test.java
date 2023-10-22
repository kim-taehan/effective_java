package org.developx.effective_java.part8.item50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Item50: 적시에 방어적 복사본을 만들라.")
class Item50Test {

    @DisplayName("생성자에 넘기고 참조된 데이터를 변경할 수 있다.")
    @Test
    void test35(){
        Date start = new Date();
        Date end = new Date();

        Period period = new Period(start, end);
        end.setYear(2000);
        assertThat(period.end()).isEqualTo(end);
    }

    @DisplayName("접근자를 통한 변경도 막을수 있다.")
    @Test
    void test36(){
        Date originDate = new Date();
        int originYear = originDate.getYear();
        Period period = new Period( originDate, originDate);

        period.end().setDate(11);
        assertThat(period.end()).isEqualTo(originDate);
    }



}