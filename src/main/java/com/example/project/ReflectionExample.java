package com.example.project;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectionExample {
    public static void main(String[] args) {
        String className = "com.project.test4.AddEquation";
        try {
            // 通过类名字符串获取 Class 对象
            Class<?> clazz = Class.forName(className);
            // 打印类的字段信息
            System.out.println("Fields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName() + " - " + field.getType());
            }

            // 打印类的方法信息
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName() + " - " + method.getReturnType());
            }

            // 获取无参构造方法并创建实例
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // 如果构造方法是私有的，需要设置可访问
            Object instance = constructor.newInstance();

            System.out.println("\nInstance created: " + instance);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
