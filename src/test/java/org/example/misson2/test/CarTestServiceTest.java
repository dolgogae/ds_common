package org.example.misson2.test;

import org.example.misson2.ReflectionUtils;
import org.example.misson2.io.service.IoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.example.misson2.ReflectionUtils.setField;
import static org.example.misson2.common.TestConstants.DRIVING_TEST;
import static org.example.misson2.common.TestConstants.PARTS_TEST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarTestServiceTest {
    @Mock
    DrivingTestService drivingTestService;
    @Mock
    PartsTestService partsTestService;
    @Mock
    IoService ioService;
    @InjectMocks
    CarTestService carTestService;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        setField(CarTestService.class, carTestService, "drivingTestService", drivingTestService);
        setField(CarTestService.class, carTestService, "partsTestService", partsTestService);
        setField(CarTestService.class, carTestService, "ioService", ioService);
    }

    @Test
    void testCar_DrivingTest() {
        int testCode = DRIVING_TEST;
        doNothing().when(drivingTestService).testDriving();
        doNothing().when(ioService).delay(2000);

        carTestService.testCar(testCode);

        verify(drivingTestService).testDriving();
        verify(ioService).delay(2000);
    }

    @Test
    void testCar_PartTest() {
        int testCode = PARTS_TEST;
        doNothing().when(partsTestService).testParts();
        doNothing().when(ioService).delay(2000);
        doNothing().when(ioService).delay(1500);

        carTestService.testCar(testCode);

        verify(partsTestService).testParts();
        verify(ioService).delay(2000);
        verify(ioService).delay(1500);
    }
}