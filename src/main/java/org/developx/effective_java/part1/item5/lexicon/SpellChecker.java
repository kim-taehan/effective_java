package org.developx.effective_java.part1.item5.lexicon;

import org.developx.effective_java.part1.item5.lexicon.Lexicon;

import java.util.List;
import java.util.Objects;

public class SpellChecker {

    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.checkValidation();
    }
    public List<String> suggestions(String word) {
        return dictionary.suggestions(word);
    }
}
