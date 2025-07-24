package org.example.misson2.car.data.breaksystem;

import org.example.misson2.car.enums.BreakSystemEnum;

public class Mando implements BreakSystem{
    @Override
    public BreakSystemEnum getBreakSystemType() {
        return BreakSystemEnum.MANDO;
    }
}
