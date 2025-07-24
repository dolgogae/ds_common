package org.example.misson2.car.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CarEnumTest {
    @Test
    void fromNumberTest(){
        EngineEnum engineEnum = EngineEnum.fromNumber(1);
        SteeringSystemEnum steeringSystemEnum = SteeringSystemEnum.fromNumber(1);
        CarTypeEnum carTypeEnum = CarTypeEnum.fromNumber(1);
        BreakSystemEnum breakSystemEnum = BreakSystemEnum.fromNumber(1);

        assertEquals(EngineEnum.GM, engineEnum);
        assertEquals(SteeringSystemEnum.BOSCH_S, steeringSystemEnum);
        assertEquals(CarTypeEnum.SEDAN, carTypeEnum);
        assertEquals(BreakSystemEnum.MANDO, breakSystemEnum);
    }

    @Test
    void fromNumber_Exception() {
        assertThrows(NumberFormatException.class, () -> EngineEnum.fromNumber(10));
        assertThrows(NumberFormatException.class, () -> SteeringSystemEnum.fromNumber(10));
        assertThrows(NumberFormatException.class, () -> CarTypeEnum.fromNumber(10));
        assertThrows(NumberFormatException.class, () -> BreakSystemEnum.fromNumber(10));
    }
}