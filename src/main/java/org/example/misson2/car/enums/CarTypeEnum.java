package org.example.misson2.car.enums;

public enum CarTypeEnum {
    SEDAN(1),
    SUV(2),
    TRUCK(3);

    private final int number;

    CarTypeEnum(int number) {
        this.number = number;
    }

    public static CarTypeEnum fromNumber(int number) {
        for (CarTypeEnum carTypeEnum : CarTypeEnum.values()) {
            if (carTypeEnum.getNumber() == number) {
                return carTypeEnum;
            }
        }
        throw new NumberFormatException();
    }

    public int getNumber() {
        return number;
    }
}
