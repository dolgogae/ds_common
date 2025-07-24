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

public class PartsTestService {
    private CarTypeEnum carType;
    private EngineEnum engine;
    private BreakSystemEnum breakSystem;
    private SteeringSystemEnum steeringSystem;

    public void testParts(Car car) {
        init(car);
        if(checkMixtureBoschPart(car)
                && checkValidBreakSystem(car) 
                && checkValidEngine(car)) {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }
    
    private void init(Car car){
        carType = car.getCarType().getCarTypeEnum();
        engine = car.getEngine().getEngineType();
        breakSystem = car.getBreakSystem().getBreakSystemType();
        steeringSystem = car.getSteeringSystem().getSteeringSystemType();
    }
    
    private boolean checkMixtureBoschPart(Car car){
        if (breakSystem == BOSCH_B && steeringSystem != BOSCH_S) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
            return false;
        }
        return true;
    }

    private boolean checkValidBreakSystem(Car car){
        if (carType == SEDAN && breakSystem == CONTINENTAL) {
            fail("Sedan에는 Continental제동장치 사용 불가");
            return false;
        }else if (carType == TRUCK && breakSystem == MANDO) {
            fail("Truck에는 Mando제동장치 사용 불가");
            return false;
        }
        return true;
    }

    private boolean checkValidEngine(Car car){
        if (carType == SUV && engine == TOYOTA) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
            return false;
        } else if (carType == TRUCK && engine == WIA) {
            fail("Truck에는 WIA엔진 사용 불가");
            return false;
        }
        return true;
    }


    private void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }
}
