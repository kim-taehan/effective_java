package org.developx.effective_java.part6.item37;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@DisplayName("ordinal 인덱싱 대신 EnumMap을 사용하라")
class Item37Test {
    @DisplayName("EnumMap을 사용해 데이터와 열거 타입을 매핑한다.")
    @Test
    void test157(){

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle,new HashSet<>());
        }

        List<Plant> garden = List.of(
                new Plant("kimtaehan", Plant.LifeCycle.ANNUAL),
                new Plant("kimtaehan2", Plant.LifeCycle.ANNUAL),
                new Plant("flow", Plant.LifeCycle.BIENNIAL)
        );

        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }

        //EnumMap은 toString을 재정의하였다.
        System.out.println(plantsByLifeCycle);
    }

    @DisplayName("스트림을 사용한 코드(enumMap을 사용하지 않는다.)")
    @Test
    void test608(){
        List<Plant> garden = List.of(
                new Plant("kimtaehan", Plant.LifeCycle.ANNUAL),
                new Plant("kimtaehan2", Plant.LifeCycle.ANNUAL),
                new Plant("flow", Plant.LifeCycle.BIENNIAL)
        );

        Map<Plant.LifeCycle, List<Plant>> collect = garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle));
        System.out.println(collect);
    }

    @DisplayName("")
    @Test
    void test507(){
        Phase.Transition.from(Phase.GAS, Phase.LIQUID);
    }




}