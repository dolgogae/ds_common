package org.example.misson2;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.CarParts;
import org.example.misson2.common.ProgramConstants;
import org.example.misson2.io.service.IoService;
import org.example.misson2.test.CarTestService;

import java.util.Scanner;

import static org.example.misson2.car.enums.CarParts.*;
import static org.example.misson2.common.ProgramConstants.*;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final IoService ioService = new IoService();
    private static final CarTestService carTestService = new CarTestService();

    private static final Car car = new Car();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarParts carPartsStep = CarType_Q;

        while (true) {
            clearScreen();
            carPartsStep.showMenu();

            int inputValue = ioService.getInputValue(sc, carPartsStep);
            if (inputValue == EXIT_PROGRAM) break;

            carPartsStep = executeByValue(inputValue, carPartsStep);
        }

        sc.close();
    }

    private static void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    private static CarParts executeByValue(int inputValue, CarParts carPartsStep) {
        if (inputValue == ProgramConstants.STEP_BACK) {
            return modifyStepBack(carPartsStep);
        } else {
            return selectPartsByStep(carPartsStep, inputValue);
        }
    }

    private static CarParts modifyStepBack(CarParts step) {
        if (step == Run_Test) {
            step = CarType_Q;
        } else if (step != CarType_Q) {
            step = step.getPrevious();
        }
        return step;
    }

    private static CarParts selectPartsByStep(CarParts step, int answer) {
        if(step == Run_Test){
            carTestService.testCar(answer, car);
        } else {
            switch (step) {
                case CarType_Q:
                    car.selectCarType(answer);
                    break;
                case Engine_Q:
                    car.selectEngine(answer);
                    break;
                case BrakeSystem_Q:
                    car.selectBreakSystem(answer);
                    break;
                case SteeringSystem_Q:
                    car.selectSteeringSystem(answer);
                    break;
            }
            step.getNext();
            ioService.delay(800);
        }
        return step;
    }
}
