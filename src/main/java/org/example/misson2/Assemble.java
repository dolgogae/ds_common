package org.example.misson2;

import org.example.misson2.execution.ExecutionService;

public class Assemble {
    private static final ExecutionService executionService = new ExecutionService();

    public static void main(String[] args) {
        executionService.executeCarMaking();
    }
}
