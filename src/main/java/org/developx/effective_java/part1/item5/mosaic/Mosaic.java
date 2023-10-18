package org.developx.effective_java.part1.item5.mosaic;

import lombok.Getter;
import org.developx.effective_java.part1.item5.mosaic.tile.Tile;

@Getter
public class Mosaic {
    private final Tile tile;
    public Mosaic(Tile tile) {
        this.tile = tile;
    }
}
