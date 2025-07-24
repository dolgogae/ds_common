package org.example.misson2.car.factory;

import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.breaksystem.Continental;
import org.example.misson2.car.data.breaksystem.Mando;
import org.example.misson2.car.enums.BreakSystemEnum;

public class BreakSystemFactory {
    public static BreakSystem createBreakSystem(BreakSystemEnum breakSystem) {
        return switch (breakSystem) {
            case MANDO -> new Mando();
            case CONTINENTAL -> new Continental();
            case BOSCH_B -> new BoschB();
        };
    }
}
