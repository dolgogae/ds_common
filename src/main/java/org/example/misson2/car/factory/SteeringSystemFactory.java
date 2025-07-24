package org.example.misson2.car.factory;

import org.example.misson2.car.data.steeringsystem.BoschS;
import org.example.misson2.car.data.steeringsystem.Mobis;
import org.example.misson2.car.data.steeringsystem.SteeringSystem;
import org.example.misson2.car.enums.SteeringSystemEnum;

public class SteeringSystemFactory {
    public static SteeringSystem createSteeringSystemFactory(SteeringSystemEnum operation) {
        return switch (operation) {
            case BOSCH_S -> new BoschS();
            case MOBIS -> new Mobis();
        };
    }
}
