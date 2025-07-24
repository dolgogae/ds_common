package org.example.misson2.car.factory;

import org.example.misson2.car.data.cartype.CarType;
import org.example.misson2.car.data.cartype.Sedan;
import org.example.misson2.car.data.cartype.Suv;
import org.example.misson2.car.data.cartype.Truck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.misson2.car.enums.CarTypeEnum.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarTypeFactoryTest {
    @Test
    void createCarType_SEDAN() {
        CarType result = CarTypeFactory.createCarType(SEDAN);

        assertEquals(Sedan.class, result.getClass());
    }

    @Test
    void createCarType_SUV() {
        CarType result = CarTypeFactory.createCarType(SUV);

        assertEquals(Suv.class, result.getClass());
    }

    @Test
    void createCarType_TRUCK() {
        CarType result = CarTypeFactory.createCarType(TRUCK);

        assertEquals(Truck.class, result.getClass());
    }

}