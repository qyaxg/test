package com.example.project;

// 定义操作数及结果范围约束的实现类
public class EquationCheckerOfRange implements EquationChecker {
    private final int min;
    private final int max;

    // 构造方法
    public EquationCheckerOfRange(int min, int max) {
        this.min = min;
        this.max = max;
    }


    //实现check方法
    @Override
    public boolean check(IEquation equation) {
        int result = equation.calculate();
        //判断操作数及结果是否在约束范围内
        return equation.getNum1() >= min && equation.getNum1() <= max &&
                equation.getNum2() >= min && equation.getNum2() <= max &&
                result >= min && result <= max;
    }
}
