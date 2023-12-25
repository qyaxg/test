package com.example.project;

// 定义减法算式子类
public class SubEquation extends AbstractEquation {
    //构造方法
    @Override
    public int calculate() {
        return getNum1() - getNum2();
    }

    // 静态内部类，构造模式
    static class SubEquationBuilder {
        private SubEquation subEquation = new SubEquation();

        SubEquationBuilder operand1(short operand1) {
            subEquation.setNum1(operand1);
            return this;
        }

        SubEquationBuilder operand2(short operand2) {
            subEquation.setNum2(operand2);
            return this;
        }

        SubEquationBuilder operator() {
            subEquation.setOperator('-');
            return this;
        }

        SubEquation build() {
            return subEquation;
        }
    }
}
