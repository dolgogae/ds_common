package org.example.misson2.car.data.steeringsystem;

import org.example.misson2.car.enums.SteeringSystemEnum;

public class BoschS implements SteeringSystem{
    @Override
    public SteeringSystemEnum getSteeringSystemType() {
        return SteeringSystemEnum.BOSCH_S;
    }
}
