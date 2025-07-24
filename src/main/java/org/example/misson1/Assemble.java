package org.example.misson1;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CarType_Q      = 0;
    private static final int Engine_Q       = 1;
    private static final int BrakeSystem_Q  = 2;
    private static final int SteeringSystem_Q = 3;
    private static final int Run_Test       = 4;

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private static final int BOSCH_S = 1, MOBIS = 2;

    public static final int INVALID_VALUE = -1;
    public static final int STEP_BACK = 0;
    public static final int EXIT_PROGRAM = -999;

    public static final int DRIVING_TEST = 1;
    public static final int PARTS_TEST = 2;

    private static int[] stack = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carPartsStep = CarType_Q;

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            showMenuByStep(carPartsStep);

            int inputValue = getInputValue(sc, carPartsStep);
            if (inputValue == EXIT_PROGRAM) break;
            if (inputValue == INVALID_VALUE) continue;

            if (inputValue == STEP_BACK) {
                carPartsStep = modifyStepBack(carPartsStep);
                continue;
            }

            carPartsStep = selectPartsByStep(carPartsStep, inputValue);
        }

        sc.close();
    }

    private static int modifyStepBack(int step) {
        if (step == Run_Test) {
            step = CarType_Q;
        } else if (step > CarType_Q) {
            step--;
        }
        return step;
    }

    private static int getInputValue(Scanner sc, int step) {
        System.out.print("INPUT > ");
        String rawInputValue = sc.nextLine().trim();

        if (rawInputValue.equalsIgnoreCase("exit")) {
            System.out.println("바이바이");
            return EXIT_PROGRAM;
        }
        return getInputValue(step, rawInputValue);
    }

    private static int getInputValue(int step, String buf) {
        try {
            int answer = Integer.parseInt(buf);
            if (isValidRange(step, answer)) {
                return answer;
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 범위내의 숫자만 입력 가능");
            delay(800);
            return INVALID_VALUE;
        }
    }

    private static int selectPartsByStep(int step, int answer) {
        switch (step) {
            case CarType_Q:
                selectCarType(answer);
                delay(800);
                step = Engine_Q;
                break;
            case Engine_Q:
                selectEngine(answer);
                delay(800);
                step = BrakeSystem_Q;
                break;
            case BrakeSystem_Q:
                selectBrakeSystem(answer);
                delay(800);
                step = SteeringSystem_Q;
                break;
            case SteeringSystem_Q:
                selectSteeringSystem(answer);
                delay(800);
                step = Run_Test;
                break;
            case Run_Test:
                testFinishedCar(answer);
                break;
        }
        return step;
    }

    private static void testFinishedCar(int answer) {
        if (answer == DRIVING_TEST) {
            testDriving();
            delay(2000);
        } else if (answer == PARTS_TEST) {
            System.out.println("Test...");
            delay(1500);
            testParts();
            delay(2000);
        }
    }

    private static void showMenuByStep(int step) {
        switch (step) {
            case CarType_Q:
                showCarTypeMenu(); break;
            case Engine_Q:
                showEngineMenu(); break;
            case BrakeSystem_Q:
                showBrakeMenu(); break;
            case SteeringSystem_Q:
                showSteeringMenu(); break;
            case Run_Test:
                showRunTestMenu(); break;
        }
    }

    private static void showCarTypeMenu() {
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
    }

    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }

    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }

    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }

    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    private static boolean isValidRange(int step, int ans) {
        switch (step) {
            case CarType_Q:
                if (isInvalidCarType(ans)) {
                    System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case Engine_Q:
                if (isInvalidEngine(ans)) {
                    System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                    return false;
                }
                break;
            case BrakeSystem_Q:
                if (isInvalidBreakSystem(ans)) {
                    System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case SteeringSystem_Q:
                if (isInvalidSteeringSystem(ans)) {
                    System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                    return false;
                }
                break;
            case Run_Test:
                if (isInvalidTest(ans)) {
                    System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                    return false;
                }
                break;
        }
        return true;
    }

    private static boolean isInvalidTest(int ans) {
        return ans < 0 || ans > 2;
    }

    private static boolean isInvalidSteeringSystem(int ans) {
        return ans < 0 || ans > 2;
    }

    private static boolean isInvalidBreakSystem(int ans) {
        return ans < 0 || ans > 3;
    }

    private static boolean isInvalidEngine(int ans) {
        return ans < 0 || ans > 4;
    }

    private static boolean isInvalidCarType(int ans) {
        return ans < 1 || ans > 3;
    }

    private static void selectCarType(int a) {
        stack[CarType_Q] = a;
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", getCarType(a));
    }

    private static String getCarType(int a) {
        return a == 1 ? "Sedan" : a == 2 ? "SUV" : "Truck";
    }

    private static void selectEngine(int a) {
        stack[Engine_Q] = a;
        String name = getEngine(a);
        System.out.printf("%s 엔진을 선택하셨습니다.\n", name);
    }

    private static String getEngine(int a) {
        return a == 1 ? "GM" : a == 2 ? "TOYOTA" : a == 3 ? "WIA" : "고장난 엔진";
    }

    private static void selectBrakeSystem(int a) {
        stack[BrakeSystem_Q] = a;
        String name = getBreakSystem(a);
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", name);
    }

    private static String getBreakSystem(int a) {
        return a == 1 ? "MANDO" : a == 2 ? "CONTINENTAL" : "BOSCH";
    }

    private static void selectSteeringSystem(int a) {
        stack[SteeringSystem_Q] = a;
        String name = getSteeringSystem(a);
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", name);
    }

    private static String getSteeringSystem(int a) {
        return a == 1 ? "BOSCH" : "MOBIS";
    }


    private static void testDriving() {
        if (!isValidCheck()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (stack[Engine_Q] == 4) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        String[] carNames = {"", "Sedan", "SUV", "Truck"};
        String[] engNames = {"", "GM", "TOYOTA", "WIA"};
        System.out.printf("Car Type : %s\n", carNames[stack[CarType_Q]]);
        System.out.printf("Engine   : %s\n", engNames[stack[Engine_Q]]);
        System.out.printf("Brake    : %s\n",
                stack[BrakeSystem_Q]==1? "Mando":
                        stack[BrakeSystem_Q]==2? "Continental":"Bosch");
        System.out.printf("Steering : %s\n",
                stack[SteeringSystem_Q]==1? "Bosch":"Mobis");
        System.out.println("자동차가 동작됩니다.");
    }

    private static boolean isValidCheck() {
        if (stack[CarType_Q] == SEDAN && stack[BrakeSystem_Q] == CONTINENTAL) return false;
        if (stack[CarType_Q] == SUV   && stack[Engine_Q] == TOYOTA)       return false;
        if (stack[CarType_Q] == TRUCK && stack[Engine_Q] == WIA)          return false;
        if (stack[CarType_Q] == TRUCK && stack[BrakeSystem_Q] == MANDO)  return false;
        if (stack[BrakeSystem_Q] == BOSCH_B && stack[SteeringSystem_Q] != BOSCH_S) return false;
        return true;
    }

    private static void testParts() {
        if (stack[CarType_Q] == SEDAN && stack[BrakeSystem_Q] == CONTINENTAL) {
            fail("Sedan에는 Continental제동장치 사용 불가");
        } else if (stack[CarType_Q] == SUV && stack[Engine_Q] == TOYOTA) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if (stack[CarType_Q] == TRUCK && stack[Engine_Q] == WIA) {
            fail("Truck에는 WIA엔진 사용 불가");
        } else if (stack[CarType_Q] == TRUCK && stack[BrakeSystem_Q] == MANDO) {
            fail("Truck에는 Mando제동장치 사용 불가");
        } else if (stack[BrakeSystem_Q] == BOSCH_B && stack[SteeringSystem_Q] != BOSCH_S) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private static void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }


    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
