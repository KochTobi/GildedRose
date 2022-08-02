package life.qbic.kata;

/**
 * <class short description - One Line!>
 * <p>
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 */
public class AgedBrie implements StorageItem {

  private int quality;
  private int sellIn;
  private static final int MAX_QUALITY = 50;

  public AgedBrie(int quality, int sellIn) {
    this.quality = quality;
    this.sellIn = sellIn;
  }

  @Override
  public void update() {
    if (quality != MAX_QUALITY) {

      quality += 1;
    }
    sellIn -= 1;
  }

  @Override
  public String name() {
    return "Aged Brie";
  }

  @Override
  public int sellIn() {
    return sellIn;
  }

  @Override
  public int quality() {
    return quality;
  }
}
