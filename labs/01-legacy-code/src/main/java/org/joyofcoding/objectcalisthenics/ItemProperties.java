package org.joyofcoding.objectcalisthenics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemProperties {
    private int sellIn;
    private int quality;
}
