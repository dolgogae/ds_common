package org.example.misson2.car.enums;

import org.junit.jupiter.api.Test;

import static org.example.misson2.car.enums.CarParts.*;
import static org.junit.jupiter.api.Assertions.*;

class CarPartsTest {
    @Test
    void isValid() {
        assertTrue(CarType_Q.isValidRange(1));
        assertTrue(Engine_Q.isValidRange(1));
        assertTrue(BreakSystem_Q.isValidRange(1));
        assertTrue(SteeringSystem_Q.isValidRange(1));
        assertTrue(Run_Test.isValidRange(1));
    }

    @Test
    void isValid_False() {
        assertFalse(CarType_Q.isValidRange(10));
        assertFalse(Engine_Q.isValidRange(10));
        assertFalse(BreakSystem_Q.isValidRange(10));
        assertFalse(SteeringSystem_Q.isValidRange(10));
        assertFalse(Run_Test.isValidRange(10));
    }

    @Test
    void showEngineMenu() {
        Engine_Q.showMenu();
    }
}