package org.example.misson2.test;

import org.example.misson2.car.data.Car;
import org.example.misson2.io.service.IoService;

import static org.example.misson2.common.TestConstants.DRIVING_TEST;
import static org.example.misson2.common.TestConstants.PARTS_TEST;

public class CarTestService {
    private final DrivingTestService drivingTestService = new DrivingTestService();
    private final PartsTestService partsTestService = new PartsTestService();
    private final IoService ioService = new IoService();

    public void testCar(int answer) {
        if (answer == DRIVING_TEST) {
            drivingTestService.testDriving();
            ioService.delay(2000);
        } else if (answer == PARTS_TEST) {
            System.out.println("Test...");
            ioService.delay(1500);
            partsTestService.testParts();
            ioService.delay(2000);
        }
    }
}
