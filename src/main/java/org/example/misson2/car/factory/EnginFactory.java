package org.example.misson2.car.factory;

import org.example.misson2.car.data.engine.Engine;
import org.example.misson2.car.data.engine.GM;
import org.example.misson2.car.data.engine.Toyota;
import org.example.misson2.car.data.engine.Wia;
import org.example.misson2.car.enums.EngineEnum;


public class EnginFactory {
    public static Engine createEnginFactory(EngineEnum operation) {
        return switch (operation) {
            case GM -> new GM();
            case TOYOTA -> new Toyota();
            case WIA -> new Wia();
        };
    }
}
