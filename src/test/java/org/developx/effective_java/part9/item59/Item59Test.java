package org.developx.effective_java.part9.item59;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Item59Test {

    @DisplayName("double로 잔돈을 계산")
    @Test
    void doubleTest(){
        double ret = Item59.calculatorDouble(1D, 0.1D, 9);
        System.out.println("잔돈="+ ret);
        assertThat(ret).isNotEqualTo(0.1D);
    }

    @DisplayName("bigDecimal로 잔돈을 계산")
    @Test
    void bigDecimalTest(){
        BigDecimal ret = Item59.calculatorBigDecimal(new BigDecimal("1.00"), new BigDecimal("0.1"), 9);
        System.out.println("잔돈="+ ret);
        assertThat(ret.compareTo(new BigDecimal("0.1"))).isEqualTo(0);
    }

    @DisplayName("int로 cent 잔돈을 계산")
    @Test
    void intTest(){
        int ret = Item59.calculatorInt(100, 10, 9);
        System.out.println("잔돈(센트)="+ ret);
        assertThat(ret).isEqualTo(10);
    }

}