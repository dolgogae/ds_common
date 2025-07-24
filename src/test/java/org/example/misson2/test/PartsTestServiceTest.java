package org.example.misson2.test;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.breaksystem.Continental;
import org.example.misson2.car.data.breaksystem.Mando;
import org.example.misson2.car.data.cartype.CarType;
import org.example.misson2.car.data.cartype.Sedan;
import org.example.misson2.car.data.cartype.Suv;
import org.example.misson2.car.data.cartype.Truck;
import org.example.misson2.car.data.engine.Engine;
import org.example.misson2.car.data.engine.Toyota;
import org.example.misson2.car.data.engine.Wia;
import org.example.misson2.car.data.steeringsystem.BoschS;
import org.example.misson2.car.data.steeringsystem.Mobis;
import org.example.misson2.car.data.steeringsystem.SteeringSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.misson2.ReflectionUtils.setField;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class PartsTestServiceTest {
    @InjectMocks
    PartsTestService partsTestService;

    @Test
    @DisplayName("BoschB & Mobis")
    void testParts_FAIL1() throws NoSuchFieldException, IllegalAccessException {
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
            partsTestService.testParts();
        }
    }

    @Test
    @DisplayName("sedan && continental")
    void testParts_FAIL2() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Sedan();
        Engine engine = new Wia();
        BreakSystem breakSystem = new Continental();
        SteeringSystem steeringSystem = new BoschS();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            partsTestService.testParts();
        }
    }

    @Test
    @DisplayName("sedan && continental")
    void testParts_FAIL3() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new Mando();
        SteeringSystem steeringSystem = new BoschS();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            partsTestService.testParts();
        }
    }

    @Test
    @DisplayName("suv && toyota")
    void testParts_FAIL4() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Suv();
        Engine engine = new Toyota();
        BreakSystem breakSystem = new Mando();
        SteeringSystem steeringSystem = new BoschS();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            partsTestService.testParts();
        }
    }

    @Test
    @DisplayName("truck && wia")
    void testParts_FAIL5() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new BoschS();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try (MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)) {
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            partsTestService.testParts();
        }
    }


    @Test
    @DisplayName("success test")
    void testParts_Success() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Toyota();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new BoschS();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            partsTestService.testParts();
        }
    }
}