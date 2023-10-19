package org.developx.effective_java.part2.item5.lexicon;

import java.util.List;

public interface Lexicon {
    boolean checkValidation();

    List<String> suggestions(String word);
}
