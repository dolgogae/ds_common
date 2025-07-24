package org.example.misson2.test;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.example.misson2.car.enums.CarTypeEnum;
import org.example.misson2.car.enums.EngineEnum;
import org.example.misson2.car.enums.SteeringSystemEnum;

import static org.example.misson2.car.enums.BreakSystemEnum.*;
import static org.example.misson2.car.enums.CarTypeEnum.*;
import static org.example.misson2.car.enums.EngineEnum.TOYOTA;
import static org.example.misson2.car.enums.EngineEnum.WIA;
import static org.example.misson2.car.enums.SteeringSystemEnum.BOSCH_S;

public class CarStatusManager {
    private CarTypeEnum carType;
    private EngineEnum engine;
    private BreakSystemEnum breakSystem;
    private SteeringSystemEnum steeringSystem;

    public void init(){
        Car car = Car.getInstance();
        try {
            carType = car.getCarType().getCarTypeEnum();
            engine = car.getEngine().getEngineType();
            breakSystem = car.getBreakSystem().getBreakSystemType();
            steeringSystem = car.getSteeringSystem().getSteeringSystemType();
        } catch (NullPointerException e){
            System.out.println("존재하지 않는 부품이 있습니다.");
        }
    }

    public boolean isNotSameBoschSteering() {
        return breakSystem == BOSCH_B && steeringSystem != BOSCH_S;
    }

    public boolean isSuvAndToyota() {
        return carType == SUV && engine == TOYOTA;
    }

    public boolean isTruckAndWia() {
        return carType == TRUCK && engine == WIA;
    }

    public boolean isSedanAndContinental() {
        return carType == SEDAN && breakSystem == CONTINENTAL;
    }

    public boolean isTruckAndMando() {
        return carType == TRUCK && breakSystem == MANDO;
    }

    public CarTypeEnum getCarType() {
        return carType;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public BreakSystemEnum getBreakSystem() {
        return breakSystem;
    }

    public SteeringSystemEnum getSteeringSystem() {
        return steeringSystem;
    }
}
