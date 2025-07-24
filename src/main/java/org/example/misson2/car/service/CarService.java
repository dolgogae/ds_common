package org.example.misson2.car.service;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.CarParts;
import org.example.misson2.io.service.IoService;

public class CarService {
    private IoService ioService = new IoService();

    public CarParts selectParts(CarParts step, int selectCode) {
        Car car = Car.getInstance();
        switch (step) {
            case CarType_Q:
                car.selectCarType(selectCode);
                break;
            case Engine_Q:
                car.selectEngine(selectCode);
                break;
            case BreakSystem_Q:
                car.selectBreakSystem(selectCode);
                break;
            case SteeringSystem_Q:
                car.selectSteeringSystem(selectCode);
                break;
        }
        step = step.getNext();
        ioService.delay(800);
        return step;
    }
}
