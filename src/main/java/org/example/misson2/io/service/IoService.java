package org.example.misson2.io.service;

import org.example.misson2.car.enums.CarParts;

import java.util.Scanner;

import static org.example.misson2.common.ProgramConstants.*;
import static org.example.misson2.common.TestConstants.CLEAR_SCREEN;

public class IoService {
    public int getInputValue(Scanner sc, CarParts step) {
        System.out.print("INPUT > ");
        String rawInputValue = sc.nextLine().trim();

        if (isExit(rawInputValue)) {
            System.out.println("바이바이");
            return EXIT_PROGRAM;
        }
        return getInputValue(step, rawInputValue);
    }

    private int getInputValue(CarParts step, String buf) {
        try {
            int answer = Integer.parseInt(buf);
            if (step.isValidRange(answer)) {
                return answer;
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 범위내의 숫자만 입력 가능");
            delay(800);
            return INVALID_VALUE;
        }
    }

    private boolean isExit(String rawInputValue) {
        return rawInputValue.equalsIgnoreCase("exit");
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    public void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }
}
