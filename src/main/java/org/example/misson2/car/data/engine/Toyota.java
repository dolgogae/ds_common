package org.example.misson2.car.data.engine;

import org.example.misson2.car.enums.EngineEnum;

public class Toyota implements Engine{
    @Override
    public EngineEnum getEngineType() {
        return EngineEnum.TOYOTA;
    }
}
