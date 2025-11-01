package com.clinicApp.clinicApp.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.util.HashSet;
import java.util.Set;

public class BeanUtilsHelper {

    // Метод возвращает имена полей, у которых значение null
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        var pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (var pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames.toArray(new String[0]);
    }
}
