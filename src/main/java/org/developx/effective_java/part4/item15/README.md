# 클래스와 멤버의 접근 권한을 최소화하라.

```text
[do not]
모든 클래스와 멤버의 접근성을 가능한 좁히자. 
package-private (이 접근제어자 사용도 고려)
배열, Collection 멤버는 불변리스트 만들어서 넘기던가 복사본을 넘기는 방식으로 진행
```
|접근제어자|권한|
|--|--|
|private|멤버를 선언한 톱 레벨 클래스에서만 접근할 수 있다.|
|package-private|멤버가 소속된 패키지 안의 모든 클래스에서 접근할 수 있다.|
|protected|package-private의 접근 범위를 포함하며 이 멤버를 선언한 클래스의 하위 클래스에서도 접근할 수 있다.|
|public|모든 곳에서 접근할 수 있다.|

```java
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
```

```java
@DisplayName("[item15] 클래스와 멤버의 접근 권한을 최소화하라.")
class Item15Test {
    
    @DisplayName("static final array 복사본 수정 후 기존 변수 체크")
    @Test
    void checkCopyArray(){
        // given
        String[] copyData = AccessControl.getVALUES();
        copyData[0] = null;
        copyData[1] = null;
        String[] copayDate2 = AccessControl.getVALUES();
        assertThat(copayDate2).hasSize(2)
                .contains("apple", "banana");
    }

    @DisplayName("immutability collection에 데이터 추가시 오류가 발생한다.")
    @Test
    void checkimmutabilityCollection(){
        // given
        List<String> valuesList = AccessControl.VALUES_LIST;

        // 불변객첵에 추가하는 경우 애러가 발생한다.
        Assertions.assertThatThrownBy(() -> valuesList.add("test"))
                .isInstanceOf(UnsupportedOperationException.class);

    }
}
```