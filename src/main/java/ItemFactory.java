/**
 * <class short description - One Line!>
 * <p>
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 */
public class ItemFactory {

  public static StorageItem createAgedBrie(int sellIn, int quality){
    return new AgedBrie(quality, sellIn);
  }

}
