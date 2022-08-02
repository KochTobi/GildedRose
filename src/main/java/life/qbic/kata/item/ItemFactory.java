package life.qbic.kata.item;

import life.qbic.kata.item.api.StorageItem;

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

  public static StorageItem createBackstagePass(int sellIn, int quality, String name){return new BackStagePass(sellIn, quality, name);}

  public static StorageItem createLegendaryItem(String name){return new LegendaryItem(name);}

  public static StorageItem createItem(String name, int sellIn, int quality) {
    return new Item(name, sellIn, quality);
  }

}
