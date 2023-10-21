# 타입 안전 이중 컨테이너를 고려하라

```text
- 타입 안정 이종 컨테이너 패턴: 컨테이너의 키를 매개변수화해서 값을 넣거나 뺄 때 키를 함께 제공
- Class<T>를 활용하는 방식
```

```java
public class Favorite {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
```

## 한정적 타입
```java
class test {
    @Override
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        Objects.requireNonNull(annotationClass);

        AnnotationData annotationData = annotationData();
        return AnnotationSupport.getAssociatedAnnotations(
                annotationData.declaredAnnotations,
                this,
                annotationClass
        );
    }
}
```