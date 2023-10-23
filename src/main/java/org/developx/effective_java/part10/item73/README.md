# Item73: 추상화 수준에 맞는 예외를 던지라.
```text
- 아래 계층의 예외를 스스로 처리할 수 없고, 상위 계층에 그대로 노출하기 곤란하다면 예외 번역을 사용하라.
- 예외 연쇄를 사용하면 상위 계층에는 맥락에 어울리는 고수준 예외를 던지면서 근본 원인도 알려줄 수 있다.
```

## 예외번역
> 상위 계층에서 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔 던져야 한다.   
> 한 메서드에서 사용하는 API가 발생시키는 Error를 그대로 내보내면 메서드를 사용하는 입장
> 에서는 메서드가 사용하는 API도 관심을 가져야 한다.

## 예외 연쇄 (exception chaining)
> 문제의 근본 원인인 저수준 예외를 고수준 예외에 실어 보내는 방식이다.

#### 예외 연쇄 호출 방법
```java
class Item73{ 
    void exception(){
        try{
            // ... // 저수준 추상화를 이용한다.
        } catch (LowerLevelException cause){
            // 저수준 예외를 고수준 예외에 실어 보낸다.
            throw new HigherLevelException(cause);
        }
    }
}
```

#### 예외 연쇄용 생성자
```java
class HigherLevelException extends Exception{
	HigherLevelException(Throwable cause){
    	super(cause);
    }
}
```