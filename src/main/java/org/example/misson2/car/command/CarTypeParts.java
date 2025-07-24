package org.example.misson2.car.command;

import org.example.misson2.car.data.cartype.CarType;

public class CarTypeParts implements PartsCommand{
    private final CarType carType;

    public CarTypeParts(CarType carType) {
        this.carType = carType;
    }

}
