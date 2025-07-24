package org.example.misson2.car.data.cartype;

import org.example.misson2.car.enums.CarTypeEnum;

public class Sedan implements CarType{
    @Override
    public CarTypeEnum getCarTypeEnum() {
        return CarTypeEnum.SEDAN;
    }
}
