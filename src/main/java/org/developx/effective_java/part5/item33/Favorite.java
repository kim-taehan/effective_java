package org.developx.effective_java.part5.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorite {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
