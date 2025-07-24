package org.example.misson2.execution;

import org.example.misson2.car.enums.CarParts;
import org.example.misson2.car.service.CarService;
import org.example.misson2.io.service.IoService;
import org.example.misson2.test.CarTestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.example.misson2.ReflectionUtils.setField;
import static org.example.misson2.common.ProgramConstants.EXIT_PROGRAM;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExecutionServiceTest {
    @Mock
    IoService ioService;
    @Mock
    CarTestService carTestService;
    @Mock
    CarService carService;
    @InjectMocks
    ExecutionService executionService;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        setField(ExecutionService.class, executionService, "ioService", ioService);
        setField(ExecutionService.class, executionService, "carTestService", carTestService);
        setField(ExecutionService.class, executionService, "carService", carService);
    }

    @Test
    void executeCarMaking() {
        doNothing().when(ioService).clearScreen();
        when(ioService.getInputValue(any(Scanner.class), any(CarParts.class)))
                .thenReturn(1)
                .thenReturn(0)
                .thenReturn(EXIT_PROGRAM);
        when(carService.selectParts(any(CarParts.class), eq(1)))
                .thenReturn(CarParts.BreakSystem_Q);

        executionService.executeCarMaking();
    }

    @Test
    void executeCarMaking_TEST() {
        doNothing().when(ioService).clearScreen();
        when(ioService.getInputValue(any(Scanner.class), any(CarParts.class)))
                .thenReturn(1)
                .thenReturn(3)
                .thenReturn(0)
                .thenReturn(EXIT_PROGRAM);
        when(carService.selectParts(any(CarParts.class), eq(1)))
                .thenReturn(CarParts.Run_Test)
                .thenReturn(CarParts.Run_Test);

        executionService.executeCarMaking();
    }
}