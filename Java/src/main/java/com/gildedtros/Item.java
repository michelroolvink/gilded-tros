package com.gildedtros;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        if (quality > 50) throw new RuntimeException("Quality cannot be greater the 50");

        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void incQuality(int multiplier) {
        for (int i = 0; i < multiplier; i++) {
           incQuality();
        }
    }

    public void incQuality() {
        if (this.quality < 50) this.quality++;
    }

    public void decQuality() {
        if (this.quality > 0) {
            this.quality--;
            if (this.sellIn < 0 && this.quality > 0) {
                this.quality--;
            }
        }
    };

    public void decSellIn() {
        this.sellIn--;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
