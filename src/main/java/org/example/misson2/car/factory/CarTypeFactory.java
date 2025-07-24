package org.example.misson2.car.factory;

import org.example.misson2.car.data.cartype.CarType;
import org.example.misson2.car.data.cartype.Sedan;
import org.example.misson2.car.data.cartype.Suv;
import org.example.misson2.car.data.cartype.Truck;
import org.example.misson2.car.enums.CarTypeEnum;

public class CarTypeFactory {
    public static CarType createCarType(CarTypeEnum carType) {
        return switch (carType) {
            case SEDAN -> new Sedan();
            case SUV -> new Suv();
            case TRUCK -> new Truck();
        };
    }
}
