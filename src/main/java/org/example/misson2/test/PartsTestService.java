package org.example.misson2.test;

public class PartsTestService {
    private CarStatusManager carStatusManager = new CarStatusManager();

    public void testParts() {
        carStatusManager.init();
        if(checkMixtureBoschPart() && checkValidBreakSystem() && checkValidEngine()) {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }
    
    private boolean checkMixtureBoschPart(){
        if (carStatusManager.isNotSameBoschSteering()) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
            return false;
        }
        return true;
    }

    private boolean checkValidBreakSystem(){
        if (carStatusManager.isSedanAndContinental()) {
            fail("Sedan에는 Continental제동장치 사용 불가");
            return false;
        }else if (carStatusManager.isTruckAndMando()) {
            fail("Truck에는 Mando제동장치 사용 불가");
            return false;
        }
        return true;
    }

    private boolean checkValidEngine(){
        if (carStatusManager.isSuvAndToyota()) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
            return false;
        } else if (carStatusManager.isTruckAndWia()) {
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
