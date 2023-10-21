package org.developx.effective_java.part4.item24;

public class TestClass {

    public void anonymous(){
        // 익명 클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 테스트");
            }
        };
        runnable.run();
    }
    public void local(){
        // 지역 클래스
        class LocalClass {
            private String name;
            // private static int staticNumber; // 정적 멤버 가질 수 없음

            public LocalClass(String name) {
                this.name = name;
            }

            public void print() {
                System.out.println("지역 클래스 테스트");
            }
        }
        LocalClass test = new LocalClass("test");
        test.print();
    }
}
