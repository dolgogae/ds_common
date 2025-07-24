package org.example.misson2.car.data.engine;

import org.example.misson2.car.enums.EngineEnum;

public class GM implements Engine{
    @Override
    public EngineEnum getEngineType() {
        return EngineEnum.GM;
    }
}
