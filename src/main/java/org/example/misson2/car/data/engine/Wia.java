package org.example.misson2.car.data.engine;

import org.example.misson2.car.enums.EngineEnum;

public class Wia implements Engine{
    @Override
    public EngineEnum getEngineType() {
        return EngineEnum.WIA;
    }
}
