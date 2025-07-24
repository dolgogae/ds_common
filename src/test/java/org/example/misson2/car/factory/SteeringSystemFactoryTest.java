package org.example.misson2.car.factory;

import org.example.misson2.car.data.breaksystem.BoschB;
import org.example.misson2.car.data.breaksystem.BreakSystem;
import org.example.misson2.car.data.breaksystem.Continental;
import org.example.misson2.car.data.breaksystem.Mando;
import org.example.misson2.car.data.steeringsystem.BoschS;
import org.example.misson2.car.data.steeringsystem.Mobis;
import org.example.misson2.car.data.steeringsystem.SteeringSystem;
import org.example.misson2.car.enums.BreakSystemEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.example.misson2.car.enums.SteeringSystemEnum.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SteeringSystemFactoryTest {
    @Test
    void createSteeringSystemFactory_BOSCH_S() {
        SteeringSystem result = SteeringSystemFactory.createSteeringSystemFactory(BOSCH_S);

        assertEquals(BoschS.class, result.getClass());
    }

    @Test
    void createSteeringSystemFactory_MOBIS() {
        SteeringSystem result = SteeringSystemFactory.createSteeringSystemFactory(MOBIS);

        assertEquals(Mobis.class, result.getClass());
    }


}