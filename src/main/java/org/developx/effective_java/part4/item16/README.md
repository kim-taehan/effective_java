# public 클래스에서 public 필드가 아닌 접근자 메서드를 사용하라.
```text
[do not]
public 클래스에서 가변 필드를 직접 노출하해서 안된다 (불변필드도 조심)
package 클래스나 중첩 private 클래스에서는 노출해도 큰 문제가 없다.
```

```java
public class Point {

    private final double x;
    private final double y;
    private final CustomColor customColor;
    public Point(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.customColor = new CustomColor(color);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return this.customColor.color;
    }
    private static class CustomColor{
        public Color color;

        public CustomColor(Color color) {
            this.color = color;
        }
    }
}
```