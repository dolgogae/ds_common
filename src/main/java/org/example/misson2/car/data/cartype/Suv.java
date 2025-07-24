package org.example.misson2.car.data.cartype;

import org.example.misson2.car.enums.CarTypeEnum;

public class Suv implements CarType{
    @Override
    public CarTypeEnum getCarTypeEnum() {
        return CarTypeEnum.SUV;
    }
}
