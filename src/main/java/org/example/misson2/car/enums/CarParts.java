package org.example.misson2.car.enums;

import java.util.function.Consumer;
import java.util.function.Function;

public enum CarParts {
    CarType_Q(showCarTypeMenu(), isValidCarType()),
    Engine_Q(showEngineMenu(), isValidEngine()),
    BreakSystem_Q(showBrakeMenu(), isInvalidBreakSystem()),
    SteeringSystem_Q(showSteeringMenu(), isValidSteeringSystem()),
    Run_Test(showRunTestMenu(), isValidTest());

    private final Consumer<Void> menu;
    private final Function<Integer, Boolean> isValid;

    private static final CarParts[] VALUES = values();
    private static int position = 0;

    CarParts(Runnable menu, Function<Integer, Boolean> isValid) {
        this.menu = (v) -> menu.run();
        this.isValid = isValid;
    }

    public CarParts getNext() {
        position = (position + 1) % VALUES.length;
        return VALUES[position];
    }

    public CarParts getPrevious() {
        position = (position - 1 + VALUES.length) % VALUES.length;
        return VALUES[position];
    }

    public void showMenu(){
        menu.accept(null);
    }

    public Boolean isValidRange(int ans){
        return isValid.apply(ans);
    }

    private static Runnable showCarTypeMenu() {
        return () -> {
            System.out.println("        ______________");
            System.out.println("       /|            |");
            System.out.println("  ____/_|_____________|____");
            System.out.println(" |                      O  |");
            System.out.println(" '-(@)----------------(@)--'");
            System.out.println("===============================");
            System.out.println("어떤 차량 타입을 선택할까요?");
            System.out.println("1. Sedan");
            System.out.println("2. SUV");
            System.out.println("3. Truck");
            System.out.println("===============================");
        };
    }

    private static Runnable showEngineMenu() {
        return () -> {
            System.out.println("어떤 엔진을 탑재할까요?");
            System.out.println("0. 뒤로가기");
            System.out.println("1. GM");
            System.out.println("2. TOYOTA");
            System.out.println("3. WIA");
            System.out.println("4. 고장난 엔진");
            System.out.println("===============================");
        };
    }

    private static Runnable showBrakeMenu() {
        return () -> {
            System.out.println("어떤 제동장치를 선택할까요?");
            System.out.println("0. 뒤로가기");
            System.out.println("1. MANDO");
            System.out.println("2. CONTINENTAL");
            System.out.println("3. BOSCH");
            System.out.println("===============================");
        };
    }

    private static Runnable showSteeringMenu() {
        return () -> {
            System.out.println("어떤 조향장치를 선택할까요?");
            System.out.println("0. 뒤로가기");
            System.out.println("1. BOSCH");
            System.out.println("2. MOBIS");
            System.out.println("===============================");
        };
    }

    private static Runnable showRunTestMenu() {
        return () -> {
            System.out.println("멋진 차량이 완성되었습니다.");
            System.out.println("어떤 동작을 할까요?");
            System.out.println("0. 처음 화면으로 돌아가기");
            System.out.println("1. RUN");
            System.out.println("2. Test");
            System.out.println("===============================");
        };
    }


    private static Function<Integer, Boolean> isValidCarType() {
        return (ans) -> {
            boolean isValidRange = ans >= 1 && ans <= 3;
            if(!isValidRange){
                System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
            }
            return isValidRange;
        };
    }

    private static Function<Integer, Boolean> isValidEngine() {
        return (ans) -> {
            boolean isValidRange = ans >= 0 && ans <= 4;
            if(!isValidRange){
                System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
            }
            return isValidRange;
        };
    }

    private static Function<Integer, Boolean> isInvalidBreakSystem() {
        return (ans) -> {
            boolean isValidRange = ans >= 0 && ans <= 3;
            if(!isValidRange){
                System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
            }
            return isValidRange;
        };
    }

    private static Function<Integer, Boolean> isValidSteeringSystem() {
        return (ans) -> {
            boolean isValidRange = ans >= 0 && ans <= 2;
            if(!isValidRange){
                System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
            }
            return isValidRange;
        };
    }

    private static Function<Integer, Boolean> isValidTest() {
        return (ans) -> {
            boolean isValidRange = ans >= 0 && ans <= 2;
            if(!isValidRange){
                System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
            }
            return isValidRange;
        };
    }

}
