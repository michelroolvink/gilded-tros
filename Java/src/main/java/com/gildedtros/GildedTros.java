package com.gildedtros;

import lombok.Getter;

@Getter
class GildedTros {
    private final Item[] items;

    public GildedTros(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            switch (item.name) {
                case "Good Wine" -> item.incQuality();
                case "Backstage passes for Re:Factor", "Backstage passes for HAXX" -> {
                    if (item.sellIn > 0 && item.sellIn < 6) {
                        item.incQuality(3);
                    } else if (item.sellIn > 0 && item.sellIn < 11) {
                        item.incQuality(2);
                    }  else if (item.sellIn > 0) {
                        item.incQuality();
                    } else {
                        item.quality = 0;
                    }
                }
                case "B-DAWG Keychain" -> { } //Do Nothing
                default -> item.decQuality();
            }

            if (!item.name.equals("B-DAWG Keychain")) {
                item.decSellIn();
            }
        }
    }
}
