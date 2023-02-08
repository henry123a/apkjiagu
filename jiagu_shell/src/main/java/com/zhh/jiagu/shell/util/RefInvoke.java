package com.zhh.jiagu.shell.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefInvoke {

    public static Object invokeStaticMethod(String class_name, String method_name, Class<?>[] pareTyple, Object[] pareVaules) {

        try {
            Class<?> obj_class = Class.forName(class_name);
            Method method = obj_class.getMethod(method_name, pareTyple);
            method.setAccessible(true);
            return method.invoke(null, pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Object invokeMethod(String class_name, String method_name, Object obj, Class<?>[] pareTyple, Object[] pareVaules) {

        try {
            Class<?> obj_class = Class.forName(class_name);
            //获取类中的所有方法，但不包括继承父类的方法
            Method method = obj_class.getDeclaredMethod(method_name, pareTyple);
            method.setAccessible(true);
            return method.invoke(obj, pareVaules);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Object getFieldOjbect(String class_name, Object obj, String filedName) {
        try {
            Class<?> obj_class = Class.forName(class_name);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Object getStaticFieldOjbect(String class_name, String filedName) {
        try {
            Class<?> obj_class = Class.forName(class_name);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldOjbect(String classname, String filedName, Object obj, Object filedVaule) {
        try {
            Class<?> obj_class = Class.forName(classname);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setStaticOjbect(String class_name, String filedName, Object filedVaule) {
        try {
            Class<?> obj_class = Class.forName(class_name);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(null, filedVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}