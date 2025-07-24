package org.example.misson2.enums;

public enum CarParts {
    CarType_Q(0),
    Engine_Q(1),
    BrakeSystem_Q(2),
    SteeringSystem_Q(3),
    Run_Test(4);

    private final int number;

    CarParts(int num) {
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

    public CarParts getPrevious() {
        CarParts[] values = values();
        int index = this.ordinal();
        if (index > 0) {
            return values[index - 1];
        } else {
            return values[values.length - 1];
        }
    }
}
