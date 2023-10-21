package org.developx.effective_java.part5.item33;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("타입 안전 이중 컨테이너를 고려하라")
class Item33Test {

    @DisplayName("타입 안정 이종 컨테이너 패턴 테스트")
    @Test
    void test79(){
        Favorite favorite = new Favorite();
        favorite.putFavorite(String.class, "hello java");
        favorite.putFavorite(Integer.class, 0xcafebabe);
        favorite.putFavorite(Class.class, Favorite.class);

        String favoriteString = favorite.getFavorite(String.class);
        int favoriteInteger = favorite.getFavorite(Integer.class);
        Class<?> favoriteClass = favorite.getFavorite(Class.class);

        System.out.printf("%s %x %s\\n", favoriteString, favoriteInteger, favoriteClass.getName());
    }

}