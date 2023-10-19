package org.developx.effective_java.part2.item5.mosaic;

import org.developx.effective_java.part2.item5.mosaic.tile.Tile;

import java.util.function.Supplier;

public class MosaicFactory {
    private MosaicFactory() {
        throw new AssertionError();
    }

    public static Mosaic create(Supplier<? extends Tile> tileFactory) {
        return new Mosaic(tileFactory.get());
    }
}
