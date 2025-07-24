package org.example.misson2.common;

import org.junit.jupiter.api.Test;

import static org.example.misson2.common.ProgramConstants.*;
import static org.example.misson2.common.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {
    @Test
    void programConstants() {
        int exitProgram = EXIT_PROGRAM;
        int invalidValue = INVALID_VALUE;
        int stepBack = STEP_BACK;

        assertEquals(-999, exitProgram);
        assertEquals(-1, invalidValue);
        assertEquals(0, stepBack);
    }

    @Test
    void testConstants() {
        int drivingTest = DRIVING_TEST;
        int partsTest = PARTS_TEST;
        String clearScreen = CLEAR_SCREEN;

        assertEquals(1, drivingTest);
        assertEquals(2, partsTest);
        assertEquals("\033[H\033[2J", clearScreen);
    }
}