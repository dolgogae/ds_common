package org.example.misson2.test;

import org.example.misson2.car.data.Car;

public class DrivingTestService {
    private CarStatusManager carStatusManager = new CarStatusManager();

    public void testDriving() {
        carStatusManager.init();
        if (checkCarBreakdown()) return;
        successDriving();
    }

    private boolean checkCarBreakdown() {
        Car car = Car.getInstance();
        if (!isValidCheck()) {
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

    private boolean isValidCheck() {
        if (carStatusManager.isSedanAndContinental()) return false;
        if (carStatusManager.isSuvAndToyota())       return false;
        if (carStatusManager.isTruckAndWia())          return false;
        if (carStatusManager.isTruckAndMando())  return false;
        if (carStatusManager.isNotSameBoschSteering()) return false;
        return true;
    }



    private void successDriving() {
        System.out.printf("Car Type : %s\n", carStatusManager.getCarType());
        System.out.printf("Engine   : %s\n", carStatusManager.getEngine());
        System.out.printf("Brake    : %s\n", carStatusManager.getBreakSystem());
        System.out.printf("Steering : %s\n", carStatusManager.getSteeringSystem());
        System.out.println("자동차가 동작됩니다.");
    }
}
