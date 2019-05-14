package com.lemisa.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
	private ReflectionUtils() {}

    @SuppressWarnings("unchecked")
    public static <T> Class<T> resolveDomainClass(Class<?> clazz) {
        Type type = clazz.getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return resolveDomainClass(clazz.getSuperclass());
    }

    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();

        Class<? extends Object> currentClazz = clazz;
        while (currentClazz != null && currentClazz != Object.class) {
            for (Field field : currentClazz.getDeclaredFields()) {
                fields.add(field);
            }

            currentClazz = currentClazz.getSuperclass();
        }

        return fields;
    }
}
