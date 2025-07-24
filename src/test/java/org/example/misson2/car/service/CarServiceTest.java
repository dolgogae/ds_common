package org.example.misson2.car.service;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.cartype.CarType;
import org.example.misson2.car.data.cartype.Truck;
import org.example.misson2.car.data.engine.Engine;
import org.example.misson2.car.data.engine.Wia;
import org.example.misson2.car.data.steeringsystem.Mobis;
import org.example.misson2.car.data.steeringsystem.SteeringSystem;
import org.example.misson2.car.enums.CarParts;
import org.example.misson2.io.service.IoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.misson2.ReflectionUtils.setField;
import static org.example.misson2.car.enums.CarParts.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock
    IoService ioService;
    @InjectMocks
    CarService carService;


    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        setField(CarService.class, carService, "ioService", ioService);
    }

    @Test
    void selectParts() throws NoSuchFieldException, IllegalAccessException {
        int selectCode = 1;
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            doNothing().when(ioService).delay(800);

            CarParts result = carService.selectParts(CarType_Q, selectCode);

            assertEquals(Engine_Q, result);
        }
    }

    @Test
    void selectParts2() throws NoSuchFieldException, IllegalAccessException {
        int selectCode = 1;
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            doNothing().when(ioService).delay(800);

            CarParts result = carService.selectParts(Engine_Q, selectCode);

            assertEquals(BreakSystem_Q, result);
        }
    }

    @Test
    void selectParts3() throws NoSuchFieldException, IllegalAccessException {
        int selectCode = 1;
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            doNothing().when(ioService).delay(800);

            CarParts result = carService.selectParts(BreakSystem_Q, selectCode);

            assertEquals(SteeringSystem_Q, result);
        }
    }

    @Test
    void selectParts4() throws NoSuchFieldException, IllegalAccessException {
        int selectCode = 1;
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            doNothing().when(ioService).delay(800);

            CarParts result = carService.selectParts(SteeringSystem_Q, selectCode);

            assertEquals(Run_Test, result);
        }
    }
}