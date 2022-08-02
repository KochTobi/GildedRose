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
    items.add(ItemFactory.createItem("+5 Dexterity Vest", 10, 20));
    items.add(ItemFactory.createAgedBrie(2, 0));
    items.add(ItemFactory.createLegendaryItem("Sulfuras, Hand of Ragnaros"));
    items.add(ItemFactory.createItem("Elixir of the Mongoose", 5, 7));
    items.add(
        ItemFactory.createBackstagePass(15, 20, "Backstage passes to a TAFKAL80ETC concert"));
    items.add(ItemFactory.createItem("Conjured Mana Cake", 3, 6));

    updateQuality();
  }

  public static void updateQuality() {
    for (int i = 0; i < items.size(); i++) {
      if ((!"Aged Brie".equals(items.get(i).name()))
          && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).name())) {
        if (items.get(i).quality() > 0) {
          if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).name())) {
            items.get(i).update();
          }
        }
      } else {
        if (items.get(i).quality() < 50) {
          items.get(i).update();

          if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).name())) {
            if (items.get(i).sellIn() < 11) {
              if (items.get(i).quality() < 50) {
                items.get(i).update();
              }
            }

            if (items.get(i).sellIn() < 6) {
              if (items.get(i).quality() < 50) {
                items.get(i).update();
              }
            }
          }
        }
      }
    }
  }

}
