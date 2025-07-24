package org.example.misson2.car.enums;

public enum EngineEnum {
    GM(1),
    TOYOTA(2),
    WIA(3);

    private final int number;

    EngineEnum(int number) {
        this.number = number;
    }

    public static EngineEnum fromNumber(int number) {
        for (EngineEnum engineEnum : EngineEnum.values()) {
            if (engineEnum.getNumber() == number) {
                return engineEnum;
            }
        }
        throw new NumberFormatException();
    }

    public int getNumber() {
        return number;
    }
}
