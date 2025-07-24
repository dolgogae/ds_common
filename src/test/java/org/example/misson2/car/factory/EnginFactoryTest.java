package org.example.misson2.car.factory;

import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.breaksystem.Continental;
import org.example.misson2.car.data.breaksystem.Mando;
import org.example.misson2.car.data.engine.Engine;
import org.example.misson2.car.data.engine.GM;
import org.example.misson2.car.data.engine.Toyota;
import org.example.misson2.car.data.engine.Wia;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.misson2.car.enums.EngineEnum.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EnginFactoryTest {
    @Test
    void createEnginFactory_GM() {
        Engine result = EnginFactory.createEnginFactory(GM);

        assertEquals(GM.class, result.getClass());
    }

    @Test
    void createEnginFactory_TOYOTA() {
        Engine result = EnginFactory.createEnginFactory(TOYOTA);

        assertEquals(Toyota.class, result.getClass());
    }

    @Test
    void createEnginFactory_WIA() {
        Engine result = EnginFactory.createEnginFactory(WIA);

        assertEquals(Wia.class, result.getClass());
    }

}