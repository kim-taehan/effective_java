package org.developx.effective_java.part2.item3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[item3] private 생성자나 열거 타입으로 싱글턴임을 보증하라")
class Item3Test {
    @DisplayName("java 리플렉션으로 다른 인스터스 얻어올때 애러가 발생한다.")
    @Test
    void reflectionTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        MySingleton instance1 = MySingleton.getInstance();
        // given
        Constructor<MySingleton> constructor = (Constructor<MySingleton>) instance1.getClass().getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThatThrownBy(() -> constructor.newInstance()).isInstanceOf(InvocationTargetException.class);
    }

    @DisplayName("직렬화를 통한 추가 인스턴스 생성을 제한한다.")
    @Test
    void serializeTest(){
        MySingleton instance = MySingleton.getInstance();
        byte[] serializedData = serialize(instance);
        MySingleton result = (MySingleton) deserialize(serializedData);
        Assertions.assertThat(instance).isSameAs(result);
    }


    private byte[] serialize(Object instance) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (bos; ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance);
        } catch (Exception e) {
            // ... 구현 생략
        }
        return bos.toByteArray();
    }

    private Object deserialize(byte[] serializedData) {
        ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
        try (bis; ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (Exception e) {
            // ... 구현 생략
        }
        return null;
    }



}