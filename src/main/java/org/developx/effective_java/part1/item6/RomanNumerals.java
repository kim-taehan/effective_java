package org.developx.effective_java.part1.item6;

import java.util.regex.Pattern;

public class RomanNumerals {

    private RomanNumerals(){
        throw new AssertionError();
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
