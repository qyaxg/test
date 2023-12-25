package com.example.project;

// 定义加法算式子类
public class AddEquation extends AbstractEquation {
    @Override
    public int calculate() {
        return getNum1() + getNum2();
    }
    // 静态内部类，构造模式
    static class AddEquationBuilder {
        private AddEquation addEquation = new AddEquation();

        AddEquationBuilder operand1(short operand1) {
            addEquation.setNum1(operand1);
            return this;
        }

        AddEquationBuilder operand2(short operand2) {
            addEquation.setNum2(operand2);
            return this;
        }

        AddEquationBuilder operator() {
            addEquation.setOperator('+');
            return this;
        }

        AddEquation build() {
            return addEquation;
        }
    }
}
