package org.example.misson2;

import org.example.misson2.execution.ExecutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssembleTest {
    @Mock
    ExecutionService executionService;
    @InjectMocks
    Assemble assemble;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        ReflectionUtils.setField(Assemble.class, assemble, "executionService", executionService);
    }

    @Test
    @DisplayName("Main test")
    void mainTest() {
        doNothing().when(executionService).executeCarMaking();
        String[] args = {"test"};

        assemble.main(args);
    }
}