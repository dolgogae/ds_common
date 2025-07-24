package org.example.misson2.test;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.example.misson2.car.enums.CarTypeEnum;
import org.example.misson2.car.enums.EngineEnum;
import org.example.misson2.car.enums.SteeringSystemEnum;
import org.example.misson2.car.repository.CarRepository;

import static org.example.misson2.car.enums.BreakSystemEnum.*;
import static org.example.misson2.car.enums.CarTypeEnum.*;
import static org.example.misson2.car.enums.EngineEnum.TOYOTA;
import static org.example.misson2.car.enums.EngineEnum.WIA;
import static org.example.misson2.car.enums.SteeringSystemEnum.BOSCH_S;

public class DrivingTestService {
    private CarTypeEnum carType;
    private EngineEnum engine;
    private BreakSystemEnum breakSystem;
    private SteeringSystemEnum steeringSystem;

    public void testDriving() {
        Car car = Car.getInstance();
        init(car);
        if (checkCarBreakdown(car)) return;
        successDriving(car);
    }

    private void init(Car car){
        carType = car.getCarType().getCarTypeEnum();
        engine = car.getEngine().getEngineType();
        breakSystem = car.getBreakSystem().getBreakSystemType();
        steeringSystem = car.getSteeringSystem().getSteeringSystemType();
    }

    private boolean checkCarBreakdown(Car car) {
        if (!isValidCheck(car)) {
            System.out.println("자동차가 동작되지 않습니다");
            return true;
        }
        if (car.getEngine() == null) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return true;
        }
        return false;
    }

    private boolean isValidCheck(Car car) {

        if (carType == SEDAN && breakSystem == CONTINENTAL) return false;
        if (carType == SUV   && engine == TOYOTA)       return false;
        if (carType == TRUCK && engine == WIA)          return false;
        if (carType == TRUCK && breakSystem == MANDO)  return false;
        if (breakSystem == BOSCH_B && steeringSystem != BOSCH_S) return false;
        return true;
    }

    private void successDriving(Car car) {
        CarTypeEnum carType = car.getCarType().getCarTypeEnum();
        EngineEnum engine = car.getEngine().getEngineType();
        BreakSystemEnum breakSystem = car.getBreakSystem().getBreakSystemType();
        SteeringSystemEnum steeringSystem = car.getSteeringSystem().getSteeringSystemType();

        System.out.printf("Car Type : %s\n", carType.name());
        System.out.printf("Engine   : %s\n", engine.name());
        System.out.printf("Brake    : %s\n", breakSystem.name());
        System.out.printf("Steering : %s\n", steeringSystem.name());
        System.out.println("자동차가 동작됩니다.");
    }
}
