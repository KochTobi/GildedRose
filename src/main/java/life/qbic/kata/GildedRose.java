package life.qbic.kata;

import java.util.ArrayList;
import java.util.List;
import life.qbic.kata.item.ItemFactory;
import life.qbic.kata.item.api.StorageItem;


public class GildedRose {

  private static List<StorageItem> items = null;

  /**
   * @param args
   */
  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items = new ArrayList<>();
    items.add(ItemFactory.createItem(10, 20, "+5 Dexterity Vest"));
    items.add(ItemFactory.createAgedBrie(2, 0));
    items.add(ItemFactory.createLegendaryItem("Sulfuras, Hand of Ragnaros"));
    items.add(ItemFactory.createItem(5, 7, "Elixir of the Mongoose"));
    items.add(
        ItemFactory.createBackstagePass(15, 20, "Backstage passes to a TAFKAL80ETC concert"));
    items.add(ItemFactory.createItem(3, 6, "Conjured Mana Cake"));

    updateQuality();
  }

  public static void updateQuality() {
    items.forEach(StorageItem::update);
  }

}
