/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
public class BackStagePassItem implements StorageItem {

  private int sellIn;

  private int quality;

  public BackStagePassItem(int sellIn, int quality) {
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public void update() {
    if (sellIn < 10 && sellIn > 5) {
      quality += 2;
    } else if (sellIn < 5) {
      quality += 3;
    } else {
      quality++;
    }
  }

  @Override
  public String name() {
    return "Backstage pass";
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
