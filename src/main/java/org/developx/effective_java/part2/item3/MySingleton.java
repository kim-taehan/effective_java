package org.developx.effective_java.part2.item3;

import java.io.Serializable;

public class MySingleton implements Serializable {
    // 여기서는 singleton 객체를 생성하는 방식은 중요하지 않다.
    private static final MySingleton INSTANCE = new MySingleton();
    private MySingleton() {
        // private 하여 다른 클래스에 생성하지 못하게 한다.
        // 확실하게 표현 해주는 것도 좋은 방식이다.
        if (INSTANCE != null) {
            throw new IllegalStateException("MySingleton 객체는 한번만 생성할 수 있습니다");
        }
    }
    public static MySingleton getInstance() {
        return INSTANCE;
    }

    // 직렬화를 통한 추가 인스턴스 생성을 제한한다.
    private Object readResolve() {
        return INSTANCE;
    }
}
