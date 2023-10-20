package org.developx.effective_java.part4.item15;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
// 클래스는 public, package-private 로 지정 (무분별한 public 제한하자)
class AccessControl {

    // 멤버: 기본적으로 멤버들은 private로 생성
    private final String name;

    private String _private() {
        return name;
    }
    protected String _protected() {
        return name;
    }

    String _packagePrivate() {
        return name;
    }

    public String _public() {
        return name;
    }

    // 배열 : 복사본을 넘기는 방식 or 불변의 collection으로 전달
    private static final String[] VALUES = {"apple", "banana"};
    public static String[] getVALUES() {
        return VALUES.clone();
    }

    // 컬렉션은 처음부터 불변으로 생성하는 경우 (공개해도 됨)
    // (List.of는 생성을 불변으로 함)
    static final List<String> VALUES_LIST = Collections.unmodifiableList(
            Arrays.asList(VALUES)
    );
}
