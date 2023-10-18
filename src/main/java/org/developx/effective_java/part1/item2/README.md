# 생성자에 매개변수가 많다면 빌더를 고려하라

```text
생성자나 정적 펙토리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 더 낫다. 
매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 그렇다. 
빌더는 점층적 생성자보다 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다. 

매개변수가 4개 이상 되어야 값어치를 한다. 하지만 API는 시간이 지날수록 매개변수가 많아지는 경향이 존재한다.
추후 빌더 패턴으로 변경해도 되지만 그전에 만든 생성자를 제거하기 쉽지 않으므로 왠만하면 빌더 패턴 사용
```

### record 에 builder 패턴 적용
> 필수, 선택 매개변수를 구분하여 입력할 수 있다.
```java
public record Email (
        // 필수
        String address,
        MailType mailType,
        
        // 선택
        String name,
        LocalDate createdDate,
        boolean agreeMarketing
) {
    public static enum MailType {
        GMAIL, NAVER;
    }
    public static class Builder {

        private final String address;
        private final MailType mailType;

        // 선택
        private String name = "";
        private LocalDate createdDate;
        private boolean agreeMarketing = false;

        public Builder(String address, MailType mailType) {
            this.address = address;
            this.mailType = mailType;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }
        public Builder agreeMarketing(boolean agreeMarketing) {
            this.agreeMarketing = agreeMarketing;
            return this;
        }

        public Email build() {
            return new Email(
                    this.address,
                    this.mailType,
                    this.name,
                    this.createdDate,
                    this.agreeMarketing
            );
        }
    }
}
```

## 계층형 구조인 경우 빌더 패턴으로 처리


```java
public abstract class EmailTemplate {

    private final String address;
    private final MailType mailType;
    public enum MailType {
        GMAIL, NAVER;
    }

    abstract static class Builder<T extends Builder<T>>{
        private String address;
        protected MailType mailType;

        public T address(String address) {
            this.address = address;
            return self();
        }

        protected abstract T self();

        abstract EmailTemplate build();
    }

    protected EmailTemplate(Builder<?> builder) {
        this.address = builder.address;
        this.mailType = builder.mailType;
    }
}
```

```java
public class Gmail extends EmailTemplate {

    private final String name;

    public static class Builder extends EmailTemplate.Builder<Builder> {

        private String name;

        @Override
        protected Builder self() {
            this.mailType = MailType.GMAIL;
            return this;
        }

        @Override
        public EmailTemplate build() {
            return new Gmail(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }

    protected Gmail(Builder builder) {
        super(builder);
        this.name = builder.name;
    }
}
```
