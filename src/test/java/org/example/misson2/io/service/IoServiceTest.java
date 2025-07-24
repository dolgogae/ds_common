package org.example.misson2.io.service;

import org.example.misson2.car.enums.CarParts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.example.misson2.common.ProgramConstants.EXIT_PROGRAM;
import static org.example.misson2.common.ProgramConstants.INVALID_VALUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IoServiceTest {
    @Mock
    Scanner scanner;
    @Mock
    CarParts step;
    @InjectMocks
    IoService ioService;

    @Test
    void getInputValue() {
        String input = "1";
        when(scanner.nextLine()).thenReturn(input);
        when(step.isValidRange(1)).thenReturn(true);

        int result = ioService.getInputValue(scanner, step);

        assertEquals(1, result);
    }

    @Test
    void getInputValue_EXIT() {
        String input = "exit";
        when(scanner.nextLine()).thenReturn(input);

        int result = ioService.getInputValue(scanner, step);

        assertEquals(EXIT_PROGRAM, result);
    }

    @Test
    void getInputValue_NumberFormatException1() {
        String input = "abcd";
        when(scanner.nextLine()).thenReturn(input);

        int result = ioService.getInputValue(scanner, step);

        assertEquals(INVALID_VALUE, result);
    }

    @Test
    void getInputValue_NumberFormatException2() {
        String input = "1";
        when(scanner.nextLine()).thenReturn(input);
        when(step.isValidRange(1)).thenReturn(false);

        int result = ioService.getInputValue(scanner, step);

        assertEquals(INVALID_VALUE, result);
    }

    @Test
    void clearScreen() {
        ioService.clearScreen();
    }
}