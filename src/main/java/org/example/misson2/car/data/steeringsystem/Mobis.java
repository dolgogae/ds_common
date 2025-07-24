package org.example.misson2.car.data.steeringsystem;

import org.example.misson2.car.enums.SteeringSystemEnum;

public class Mobis implements SteeringSystem{
    @Override
    public SteeringSystemEnum getSteeringSystemType() {
        return SteeringSystemEnum.MOBIS;
    }
}
