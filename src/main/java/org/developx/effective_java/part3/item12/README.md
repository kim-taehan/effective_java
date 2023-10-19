# toString을 항상 재정의하라

## toString 재정의 규칙
1. toString의 규약은 "모든 하위 클래스에서 이 메서드를 재정의하라" 라고 한다.
2. toString은 보안에 문제가 되지 않는 한 그 객체가 가진 주요 정보 모두를 반환하는게 좋다.
3. 정적 유틸리스 클래스라면 toString을 제공할 이유가 없다.
4. 레코드, 열거 타입도 자바가 완벽한 toString을 제공하기 때문에 재정의하지 않아도 된다.
5. 하지만 하위클래스들이 공유해야 하는 문자열이 있는 추상 클래스라면 toString을 재정의.

```java
public class Mail {

    static enum MailType {
        GMAIL("gmail.com"), NAVER("naver.com");
        MailType(String text) {
            this.text = text;
        }
        private final String text;
    }

    private final String domain;
    private final MailType mailType;

    public Mail(String domain, MailType mailType) {
        this.domain = domain;
        this.mailType = mailType;
    }

    @Override
    public String toString() {
        return String.format("MAIL{ %s@%s }", domain, mailType.text);
    }
}
```

```java
@DisplayName("[Item12] toString을 항상 재정의하라")
class Item12Test {

    @DisplayName("toString 은 인지하기 쉽게 모든정보가 보인다.")
    @Test
    void toStringTest(){
        Mail gmail = new Mail("kimtaehan", Mail.MailType.GMAIL);
        Mail nMail = new Mail("test", Mail.MailType.NAVER);

        System.out.println(gmail); // MAIL{ kimtaehan@gmail.com }
        System.out.println(nMail); // MAIL{ test@naver.com }
    }
}
```