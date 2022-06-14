
import spock.lang.Specification

class GildedRoseSpec extends Specification {

  def "at the end of the day item quality decreases by 1 and sellIn date decreases by 1"() {

    given:
    def items = new ArrayList<Item>();

    def item = new Item("Test Item", 10, 20)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() < 20
    item.getSellIn() < 10
  }

  def "the quality of an item is never negative"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Nearly negative item", 10, 0)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() >= 0
  }

  def "aged brie increases in quality over time"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Aged Brie", 2, 0)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() > 0
  }

  def "aged brie increases in quality even if the sellIn passed"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Aged Brie", -1, 0)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() > 0
  }

  def "the quality of an item is never more than 50"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Aged Brie", 2, 50)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() == 50
  }

  def "Sulfuras does not loose quality"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.getQuality() == 80
  }

  def "Sulfuras never has to be sold"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.sellIn == 0
  }

  def "once the sellIn date passed, quality decreases twice as fast"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Passed sellIn date", -1, 20);
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.quality == 18
  }

  def "with 11 or more days until the concert, backstage passes increase in quality by 1"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 20)
    items.add(item);
    GildedRose.items = items
    when:
    item.setQuality(20)
    GildedRose.updateQuality()
    then:
    item.quality == 21
    where:
    sellIn << [11,100,20,44]
  }

  def "when the backstage pass increases in quality, the quality must not be greater than 50"() {
    when:
    def items = new ArrayList<Item>();
    def item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 50)
    def item2 = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 47)
    def item3 = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 48)
    def item4 = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 49)
    items.addAll(item, item2, item3, item4);
    GildedRose.items = items
    GildedRose.updateQuality()
    then:
    items.every {it.quality <= 50}
    where:
    sellIn << [0,1,2,3,4,5,6,7,8,9,10,11,20,44]
  }

  def "in between 5-10 days before the concert, backstage passes increase in quality by 2"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 20)
    items.add(item);
    GildedRose.items = items
    when:
    item.setQuality(20)
    GildedRose.updateQuality()
    then:
    item.quality == 22
    where:
    sellIn << [10,9,8,7,6]
  }
  def "in between 1-5 days before the concert, backstage passes increase in quality by 3"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 20)
    items.add(item);
    GildedRose.items = items
    when:
    item.setQuality(20)
    GildedRose.updateQuality()
    then:
    item.quality == 23
    where:
    sellIn << [5,4,3,2,1]
  }

  def "at the day of the concert, the quality drops to 0"() {
    given:
    def items = new ArrayList<Item>();
    def item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
    items.add(item);
    GildedRose.items = items
    when:
    GildedRose.updateQuality()
    then:
    item.quality == 0
  }






}
