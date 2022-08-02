package life.qbic.kata;

public class Item implements StorageItem {

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    protected void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    protected void setQuality(int quality) {
        if (quality < 0) {
            throw new IllegalArgumentException("Quality must never be negative");
        }
        this.quality = quality;
    }


    @Override
    public void update() {
        if (sellIn < 0) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
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

    @Override
    public String name() {
        return getName();
    }

    @Override
    public int sellIn() {
        return getSellIn();
    }

    @Override
    public int quality() {
        return getQuality();
    }
}
