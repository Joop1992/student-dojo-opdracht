package org.joyofcoding.objectcalisthenics;

import java.util.List;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static void main(String[] args) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(Item.makeItems());
    }

    public void updateQuality(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String name = item.getName();
            if (notAgedBrie(name) && notBackStagePasses(name)){
                if(qualityAboveZero(item) && notSulfaras(name)) {
                    reduceQuality(item);
                }
            } else {
                if(qualityBelowFifty(item)){
                    increaseQuality(item);
                }

                if (name.equals(BACKSTAGE_PASSES)) {
                    if (sellInBelowTreshold(item, 11)) {
                        if (qualityBelowFifty(item)) {
                            increaseQuality(item);
                        }
                    }

                    if (sellInBelowTreshold(item, 6)) {
                        if (qualityBelowFifty(item)) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (notSulfaras(name)) {
                reduceSellIn(item);
            }

            if (sellInBelowTreshold(item, 0)) {
                if (notAgedBrie(name) && notBackStagePasses(name) && qualityAboveZero(item) && notSulfaras(name)){
                        reduceQuality(item);
                }
                if(notAgedBrie(name) && isBackStagePasses(name)) {
                    removeQuality(item);
                }
                if (isAgedBrie(name) && qualityBelowFifty(item)) {
                    increaseQuality(item);
                }
            }
        }
    }

    private boolean sellInBelowTreshold(Item item, int treshold) {
        return item.getItemProperties().getSellIn() < treshold;
    }

    private boolean qualityBelowFifty(Item item) {
        return item.getItemProperties().getQuality() < 50;
    }

    private void reduceSellIn(Item item) {
        item.getItemProperties().setSellIn(item.getItemProperties().getSellIn() - 1);
    }

    private boolean notSulfaras(String name) {
        return !name.equals(SULFURAS);
    }

    private boolean qualityAboveZero(Item item) {
        return item.getItemProperties().getQuality() > 0;
    }

    private boolean isBackStagePasses(String name) {
        return name.equals(BACKSTAGE_PASSES);
    }

    private boolean notBackStagePasses(String name) {
        return !name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(String name) {
        return name.equals(AGED_BRIE);
    }

    private boolean notAgedBrie(String name) {
        return !name.equals(AGED_BRIE);
    }

    private void removeQuality(Item item) {
        item.getItemProperties().setQuality(item.getItemProperties().getQuality() - item
                .getItemProperties().getQuality
                        ());
    }

    private void increaseQuality(Item item) {
        item.getItemProperties().setQuality(item.getItemProperties().getQuality() + 1);
    }

    private void reduceQuality(Item item) {
        item.getItemProperties().setQuality(item.getItemProperties().getQuality() - 1);
    }
}
