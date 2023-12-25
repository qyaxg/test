package com.example.project;

import java.util.Objects;
//算式抽象类
public abstract class AbstractEquation implements IEquation{
    private short num1;
    private short num2;
    private char operator;

    // 构造方法
    public AbstractEquation(short num1, short num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public AbstractEquation() {
    }
    //实现get、set方法
    @Override
    public int getNum1() {
        return num1;
    }

    @Override
    public int  getNum2() {
        return num2;
    }

    @Override
    public char getOperator() {
        return operator;
    }

    @Override
    public void setNum1(short num1) {
        this.num1 = num1;
    }

    @Override
    public void setNum2(short num2) {
        this.num2 = num2;
    }

    @Override
    public void setOperator(char operator) {
        this.operator = operator;
    }

    @Override
    public int calculate() {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
    //实现equals、hashCode方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEquation that = (AbstractEquation) o;
        return num1 == that.num1 &&
                num2 == that.num2 &&
                operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, operator);
    }
}
