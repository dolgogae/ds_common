package org.example.misson2.execution;

import org.example.misson2.car.data.Car;
import org.example.misson2.car.enums.CarParts;
import org.example.misson2.car.service.CarService;
import org.example.misson2.common.ProgramConstants;
import org.example.misson2.io.service.IoService;
import org.example.misson2.test.CarTestService;

import java.util.Scanner;

import static org.example.misson2.car.enums.CarParts.CarType_Q;
import static org.example.misson2.car.enums.CarParts.Run_Test;
import static org.example.misson2.common.ProgramConstants.EXIT_PROGRAM;

public class ExecutionService {
    private static final IoService ioService = new IoService();
    private static final CarTestService carTestService = new CarTestService();
    private static final CarService carService = new CarService();

    public void executeCarMaking(){
        Scanner sc = new Scanner(System.in);
        CarParts carPartsStep = CarType_Q;

        while (true) {
            ioService.clearScreen();
            carPartsStep.showMenu();

            int inputValue = ioService.getInputValue(sc, carPartsStep);
            if (inputValue == EXIT_PROGRAM) break;

            carPartsStep = executeByValue(inputValue, carPartsStep);
        }

        sc.close();
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
            carTestService.testCar(answer);
        } else {
            step = carService.selectParts(step, answer);
        }
        return step;
    }
}
