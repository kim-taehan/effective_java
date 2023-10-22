package org.developx.effective_java.part8.item53;

public final class Item53 {
    private Item53() {
        throw new AssertionError();
    }

    static int sum(int... args) {
        int ret = 0;
        for (int arg : args) {
            ret += arg;
        }
        return ret;
    }

    static int min(int firstArg, int... args) {
        int ret = firstArg;
        for (int arg : args) {
            if (ret > arg) {
                ret = arg;
            }
        }
        return ret;
    }
}
