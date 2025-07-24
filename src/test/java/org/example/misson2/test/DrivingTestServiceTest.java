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
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.io.PrintStream;

import static org.example.misson2.ReflectionUtils.setField;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class DrivingTestServiceTest {
    @Mock
    PrintStream printStream;
    @InjectMocks
    DrivingTestService drivingTestService;

    @Test
    @DisplayName("truck && wia")
    void testDriving_FAIL1() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Wia();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }

    @Test
    @DisplayName("sedan && continental")
    void testDriving_FAIL2() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Sedan();
        Engine engine = new Wia();
        BreakSystem breakSystem = new Continental();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }

    @Test
    @DisplayName("suv && toyota")
    void testDriving_FAIL3() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Suv();
        Engine engine = new Toyota();
        BreakSystem breakSystem = new Continental();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }

    @Test
    @DisplayName("truck && mando")
    void testDriving_FAIL4() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Toyota();
        BreakSystem breakSystem = new Mando();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }

    @Test
    @DisplayName("bosch_b && !bosch_s")
    void testDriving_FAIL5() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = new Toyota();
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }

    @Test
    @DisplayName("engine null")
    void testDriving_FAIL6() throws NoSuchFieldException, IllegalAccessException {
        Car car = Car.getInstance();
        CarType carType = new Truck();
        Engine engine = null;
        BreakSystem breakSystem = new BoschB();
        SteeringSystem steeringSystem = new Mobis();

        setField(Car.class, car, "carType", carType);
        setField(Car.class, car, "engine", engine);
        setField(Car.class, car, "breakSystem", breakSystem);
        setField(Car.class, car, "steeringSystem", steeringSystem);

        try(MockedStatic<Car> mockedStaticCar = mockStatic(Car.class)){
            mockedStaticCar.when(Car::getInstance).thenReturn(car);
            drivingTestService.testDriving();
        }
    }


    @Test
    @DisplayName("success test")
    void testDriving_Success() throws NoSuchFieldException, IllegalAccessException {
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
            drivingTestService.testDriving();
        }
    }
}