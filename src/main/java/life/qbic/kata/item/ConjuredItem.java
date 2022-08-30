package life.qbic.kata.item;

import life.qbic.kata.item.api.StorageItem;

public class ConjuredItem implements StorageItem {

    private final String name;
    private int sellIn;
    private int quality;

    public ConjuredItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {

    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int sellIn() {
        return this.sellIn;
    }

    @Override
    public int quality() {
        return this.quality;
    }
}
