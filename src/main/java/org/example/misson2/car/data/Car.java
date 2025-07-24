package org.example.misson2.car.data;

import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.cartype.CarType;
import org.example.misson2.car.data.engine.Engine;
import org.example.misson2.car.data.steeringsystem.SteeringSystem;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.example.misson2.car.enums.CarTypeEnum;
import org.example.misson2.car.enums.EngineEnum;
import org.example.misson2.car.enums.SteeringSystemEnum;
import org.example.misson2.car.factory.BreakSystemFactory;
import org.example.misson2.car.factory.CarTypeFactory;
import org.example.misson2.car.factory.EnginFactory;
import org.example.misson2.car.factory.SteeringSystemFactory;

public class Car {
    private static Car instance;
    CarType carType;
    Engine engine;
    BreakSystem breakSystem;
    SteeringSystem steeringSystem;

    private Car(){}

    public static Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }
        return instance;
    }

    public void selectCarType(int command) {
        CarTypeEnum carTypeEnum = CarTypeEnum.fromNumber(command);
        this.carType = CarTypeFactory.createCarType(carTypeEnum);
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", carTypeEnum.name());
    }

    public void selectEngine(int command) {
        EngineEnum engineEnum = EngineEnum.fromNumber(command);
        this.engine = EnginFactory.createEnginFactory(engineEnum);
        System.out.printf("%s 엔진을 선택하셨습니다.\n", engineEnum.name());
    }

    public void selectBreakSystem(int command) {
        BreakSystemEnum breakSystemEnum = BreakSystemEnum.fromNumber(command);
        this.breakSystem = BreakSystemFactory.createBreakSystem(breakSystemEnum);
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", breakSystemEnum.name());
    }

    public void selectSteeringSystem(int command) {
        SteeringSystemEnum steeringSystemEnum = SteeringSystemEnum.fromNumber(command);
        this.steeringSystem = SteeringSystemFactory.createSteeringSystemFactory(steeringSystemEnum);
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", steeringSystemEnum.name());
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public BreakSystem getBreakSystem() {
        return breakSystem;
    }

    public SteeringSystem getSteeringSystem() {
        return steeringSystem;
    }
}
