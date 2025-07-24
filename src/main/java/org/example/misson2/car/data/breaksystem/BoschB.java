package org.example.misson2.car.data.breaksystem;

import org.example.misson2.car.enums.BreakSystemEnum;

public class BoschB implements BreakSystem{
    @Override
    public BreakSystemEnum getBreakSystemType() {
        return BreakSystemEnum.BOSCH_B;
    }
}
