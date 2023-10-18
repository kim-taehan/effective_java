# 생성자 대신 정적 팩토리 매서드를 고려하라

## 장점 
- 이름을 가질 수 있다.
- 매번 인스턴스를 생성하지 않아도 된다.
- 반환 타입의 하위 타입객체를 반환할 수 있다.
- 입력변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
- 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

### 널리, 그리고 자주 사용되는 명명법
|메서드명|내용|예시|
|:---:|---|---|
|from|매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드|Date d = Date.from(instant);|
|of|여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드|Set<Rank> faceCards - EnumSet.of(JACK, QUEEN, KING);|
|valueOf|from과 of의 더 자세한 버전|BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);|
|instance, getInstance|(매개변수를 받는다면)명시한 인스턴스를 반환, 같은 인스턴스임을 보장하지는 않는다.|StackWalker luke = StackWalker.getInstance(options);|
|create, newInstance|instance 혹은 getInstance와 같지만, 매번 새로운 인스턴스를 생성해 반환함을 보장|Object newArray = Array.newInstance(classObject, arrayLen);|
|getType|getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. Type은 팩터리 메서드가 반환할 객체의 타입이다.|FileStore fs = Files.getFileStore(path);|
|newType|newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. Type은 팩터리 메서드가 반환할 객체의 타입이다.|BufferedReader br = Files.newBufferedReader(path);|
|type|getType과 newType 축소버전|List<Complaint> litany = Collections.list(legacyLitany);|

