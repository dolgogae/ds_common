package org.example.misson2.car.service;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.CarParts;
import org.example.misson2.io.service.IoService;

public class CarService {
    private final IoService ioService = new IoService();

    public void selectParts(CarParts step, int answer) {
        Car car = Car.getInstance();
        switch (step) {
            case CarType_Q:
                car.selectCarType(answer);
                break;
            case Engine_Q:
                car.selectEngine(answer);
                break;
            case BrakeSystem_Q:
                car.selectBreakSystem(answer);
                break;
            case SteeringSystem_Q:
                car.selectSteeringSystem(answer);
                break;
        }
        step.getNext();
        ioService.delay(800);
    }
}
