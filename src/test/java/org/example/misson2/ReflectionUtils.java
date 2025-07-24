package org.example.misson2;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static void setField(Class<?> clazz, Object sourceClass, String fieldName, Object targetField) throws NoSuchFieldException, IllegalAccessException {
        Field executionServiceField = clazz.getDeclaredField(fieldName);
        executionServiceField.setAccessible(true);
        executionServiceField.set(sourceClass, targetField);
    }
}
