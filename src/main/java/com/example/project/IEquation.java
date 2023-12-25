package com.example.project;

//算式接口
public interface IEquation {
    //get,set方法
    int getNum1();

    int  getNum2();

    char getOperator();

    void setNum1(short num1);

    void setNum2(short num2);

    void setOperator(char operator);
//calculate方法
    int calculate();
}
