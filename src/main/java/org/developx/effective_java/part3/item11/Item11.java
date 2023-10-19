package org.developx.effective_java.part3.item11;

import java.util.Objects;

public class Item11 {
    private final String name;
    private final int age;

    public Item11(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item11 item11 = (Item11) o;
        return age == item11.age && Objects.equals(name, item11.name);
    }

    // 만약 해쉬코드로 자주 사용되는 경우 처리방법
    private int hashCode = 0;

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = Objects.hash(name, age);
        }
        return hashCode;
    }
}
