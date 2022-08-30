package life.qbic.kata.item;

import life.qbic.kata.item.api.StorageItem;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
class BackStagePass implements StorageItem {

  private int sellIn;
  private final String concertName;
  private int quality;

  public BackStagePass(int sellIn, int quality, String concertName) {
    this.sellIn = sellIn;
    this.quality = quality;
    this.concertName = concertName;
  }

  @Override
  public void update() {
    int updatedQuality = quality;

    if (sellIn <= 10 && sellIn > 5) {
      updatedQuality += 2;
    } else if (sellIn <= 5 && sellIn > 0) {
      updatedQuality += 3;
    } else if (sellIn == 0) {
      updatedQuality = 0;
    } else {
      updatedQuality++;
    }
    if (updatedQuality <= 50 ) {
      quality = updatedQuality;
    }
  }

  @Override
  public String name() {
    return "Backstage passes to " + concertName;
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
