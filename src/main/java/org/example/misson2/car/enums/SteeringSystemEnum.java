package org.example.misson2.car.enums;

public enum SteeringSystemEnum {
    BOSCH_S(1),
    MOBIS(2);

    private final int number;

    SteeringSystemEnum(int number) {
        this.number = number;
    }

    public static SteeringSystemEnum fromNumber(int number) {
        for (SteeringSystemEnum steeringSystemEnum : SteeringSystemEnum.values()) {
            if (steeringSystemEnum.getNumber() == number) {
                return steeringSystemEnum;
            }
        }
        throw new NumberFormatException();
    }

    public int getNumber() {
        return number;
    }
}
