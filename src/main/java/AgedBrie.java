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

  public AgedBrie(int quality, int sellIn) {
    this.quality = quality;
    this.sellIn = sellIn;
  }

  @Override
  public void update() {

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
