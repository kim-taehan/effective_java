package org.developx.effective_java.part2.item5;

import org.developx.effective_java.part2.item5.lexicon.Lexicon;
import org.developx.effective_java.part2.item5.lexicon.SpellChecker;
import org.developx.effective_java.part2.item5.mosaic.Mosaic;
import org.developx.effective_java.part2.item5.mosaic.MosaicFactory;
import org.developx.effective_java.part2.item5.mosaic.tile.AdvanceTile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[item5] 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라")
class Item5Test {

    @DisplayName("의존성 주입을 통한 사전기능 구현")
    @Test
    void diTest(){
        Lexicon tempLexicon = new Lexicon() {
            @Override
            public boolean checkValidation() {
                return false;
            }
            @Override
            public List<String> suggestions(String word) {
                return List.of("apple", "banana");
            }
        };
        // given
        SpellChecker spellChecker = new SpellChecker(tempLexicon);
        // when

        // then
        assertThat(spellChecker.isValid("test")).isFalse();
        assertThat(spellChecker.suggestions("test"))
                .hasSize(2)
                .contains("apple", "banana");
    }

    @DisplayName("참조할 자원의 팩토리를 주입하기 Supplier")
    @Test
    void mosaicTest(){
        AdvanceTile advanceTile = new AdvanceTile();
        Mosaic mosaic = MosaicFactory.create(() -> advanceTile);

        assertThat(mosaic)
                .isNotNull()
                .extracting("tile")
                .isEqualTo(advanceTile);
    }


}