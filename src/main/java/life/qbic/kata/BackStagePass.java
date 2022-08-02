package life.qbic.kata;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
public class BackStagePass implements StorageItem {

  private int sellIn;
  private String concertName;
  private int quality;

  public BackStagePass(int sellIn, int quality, String concertName) {
    this.sellIn = sellIn;
    this.quality = quality;
    this.concertName = concertName;
  }

  @Override
  public void update() {
    int alteredQuality = quality;

    if (sellIn < 10 && sellIn > 5) {
      alteredQuality += 2;
    } else if (sellIn < 5) {
      alteredQuality += 3;
    } else {
      alteredQuality++;
    }
    if (alteredQuality <= 50 ) {
      quality = alteredQuality;
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
