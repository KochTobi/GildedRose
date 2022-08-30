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
        if (sellIn < 0) {
            decreaseQualityBy(4);
        } else {
            decreaseQualityBy(2);
        }
        setSellIn(sellIn - 1);
    }

    protected void decreaseQualityBy(int amount){
        if (quality - amount <= 0) {
            quality = 0;
            return;
        }
        setQuality(quality - amount);
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
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
