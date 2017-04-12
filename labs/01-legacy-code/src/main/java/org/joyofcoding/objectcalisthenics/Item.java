package org.joyofcoding.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Item {
    private String name;
    private ItemProperties itemProperties;

    public static List<Item> makeItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(Item.builder()
                .name("+5 Dexterity Vest")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(10)
                                .quality(20).build()
                ).build());
        items.add(Item.builder()
                .name("Aged Brie")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(2)
                                .quality(0).build()
                ).build());
        items.add(Item.builder()
                .name("Elixir of the Mongoose")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(5)
                                .quality(7).build()
                ).build());
        items.add(Item.builder()
                .name("Sulfuras, Hand of Ragnaros")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(0)
                                .quality(80).build()
                ).build());
        items.add(Item.builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(15)
                                .quality(20).build()
                ).build());
        items.add(Item.builder()
                .name("Conjured Mana Cake")
                .itemProperties(
                        ItemProperties.builder()
                                .sellIn(3)
                                .quality(6).build()
                ).build());
        return items;
    }
}
