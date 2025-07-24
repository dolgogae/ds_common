package org.example.misson2.car.data.engine;

import org.example.misson2.car.enums.EngineEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GMTest {
    @Test
    void gmTest(){
        GM gm = new GM();
        EngineEnum engineType = gm.getEngineType();

        assertEquals(EngineEnum.GM, engineType);
    }
}