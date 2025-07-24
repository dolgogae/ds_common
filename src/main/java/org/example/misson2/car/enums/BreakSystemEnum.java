package org.example.misson2.car.enums;

public enum BreakSystemEnum {
    MANDO(1),
    CONTINENTAL(2),
    BOSCH_B(3);

    private final int number;

    BreakSystemEnum(int number) {
        this.number = number;
    }

    public static BreakSystemEnum fromNumber(int number) {
        for (BreakSystemEnum breakSystemEnum : BreakSystemEnum.values()) {
            if (breakSystemEnum.getNumber() == number) {
                return breakSystemEnum;
            }
        }
        throw new NumberFormatException();
    }

    public int getNumber() {
        return number;
    }
}
