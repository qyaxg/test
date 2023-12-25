package com.example.project;

import java.util.Random;

// 算式工厂类
public class EquationFactory {
    private static final Random random = new Random();

    IEquation getEquation(String type) {
        if ("Add".equalsIgnoreCase(type)) {
            return new AddEquation.AddEquationBuilder()
                    .operand1((short) random.nextInt(101))
                    .operand2((short) random.nextInt(101))
                    .operator()
                    .build();
        } else if ("Sub".equalsIgnoreCase(type)) {
            return new SubEquation.SubEquationBuilder()
                    .operand1((short) random.nextInt(101))
                    .operand2((short) random.nextInt(101))
                    .operator()
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid equation type: " + type);
        }
    }

    IEquation getEquationRandom() {
        if (random.nextBoolean()) {
            return getEquation("Add");
        } else {
            return getEquation("Sub");
        }
    }
}

