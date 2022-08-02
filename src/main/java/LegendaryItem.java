public class LegendaryItem implements StorageItem {

    private final String name;
    private static final int sellIn = 0;
    private static final int quality = 80;

    public LegendaryItem(String name) {
        super();
        this.name = name;
    }

    @Override
    public void update() {//nothing to do here, legendary items don't lose quality
    }

    @Override
    public String name() {
        return name;
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
