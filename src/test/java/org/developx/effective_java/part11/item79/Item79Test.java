package org.developx.effective_java.part11.item79;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@DisplayName("Item79 과도한 동기화는 피하라")
class Item79Test {

    @DisplayName("")
    @Test
    void test276(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) s.removeObserver(this);
            }
        });

        extracted(set);
    }

    private static void extracted(ObservableSet<Integer> set) {
        for (int i = 0; i < 100; i++) {
            System.out.println("call=" + i);
            set.add(i);
        }
    }


    @DisplayName("")
    @Test
    void test906(){

        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        extracted(set);
    }


}