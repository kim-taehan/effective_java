# 스트림에서는 부작용 없는 함수를 사용하라.

```text
- foreach 연산은 병렬화 할 수 없는 반복문이라 계산하는데 사용하지 말자 (이것만 썼던것 같은데)
- 수집기(collector) 사용에 익숙해지자. (toList, toSet, toMap, groupingBy, joining)
```


```java
class Item46Test {

    @DisplayName("stream을 활용해 빈도표를 초기화 한다.")
    @Test
    void groupingByTest(){
        Map<String, Long> collect = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));
        System.out.println(collect);
    }
    
    @DisplayName("빈도표에서 가장 많은 3개를 뽑아낸다.")
    @Test
    void top3Test(){
        Map<String, Long> freq = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));

        List<String> collect = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(3)
                .collect(Collectors.toList());

        assertThat(collect).contains("green", "black", "white");
    }
    
    @DisplayName("toMap 수집기를 사용하여 Map에 맵핑해보자.")
    @Test
    void toMapTest(){
        Map<String, Long> freq = FREQ.stream()
                .collect(groupingBy(key -> key, counting()));


        Map<Long, String> collect = freq.keySet().stream()
                .collect(toMap(freq::get, e -> e));

        System.out.println(collect);
    }

    @DisplayName("흰색과 흰색이 아닌 그룹화")
    @Test
    void test485(){
        Map<String, List<String>> collect = FREQ.stream()
                .collect(groupingBy(word -> word.equals("white") ? "true" : "false"));

        System.out.println(collect);
    }
}
```