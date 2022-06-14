
public class Item implements StorageItem{

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

  public void setSellIn(int sellIn) {
    this.sellIn = sellIn;
  }

  public int getQuality() {
    return quality;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  @Override
  public void update() {

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
