package org.example.misson2.car.factory;

import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.breaksystem.Continental;
import org.example.misson2.car.data.breaksystem.Mando;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BreakSystemFactoryTest {
    @Test
    void createBreakSystem_MANDO() {
        BreakSystem result = BreakSystemFactory.createBreakSystem(BreakSystemEnum.MANDO);

        assertEquals(Mando.class, result.getClass());
    }

    @Test
    void createBreakSystem_CONTINENTAL() {
        BreakSystem result = BreakSystemFactory.createBreakSystem(BreakSystemEnum.CONTINENTAL);

        assertEquals(Continental.class, result.getClass());
    }

    @Test
    void createBreakSystem_BOSCHB() {
        BreakSystem result = BreakSystemFactory.createBreakSystem(BreakSystemEnum.BOSCH_B);

        assertEquals(BoschB.class, result.getClass());
    }
}