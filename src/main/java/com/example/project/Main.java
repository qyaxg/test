package com.example.project;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

// 主类
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入产生题目的数量：");
        int n = in.nextInt();

        // 创建算式产生类和约束实例
        System.out.println("请输入约束范围：");
        System.out.println("min:");
        int min = in.nextInt();
        System.out.println("max:");
        int max = in.nextInt();
        EquationCollection equationCollection = new EquationCollection();
        EquationChecker checker = new EquationCheckerOfRange(min, max);

        // 产生n个算式
        equationCollection.generate(n, checker);
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(equationCollection);
        System.out.println(s);
        EquationCollection iEquations = objectMapper.readValue(s, EquationCollection.class);
        //打印题目
        System.out.println("------------题目-------------");
        printEquations(equationCollection);
        //打印答案
        System.out.println("------------答案-------------");
        printResults(equationCollection);
    }

    // 打印算式的方法
    private static void printEquations(Iterable<IEquation> equations) {
        Iterator<IEquation> iterator = equations.iterator();
        //题号
        int index = 1;
        while (iterator.hasNext()) {
            IEquation equation = iterator.next();
            System.out.println((index++) + ":\t" + equation.getNum1() + " " + equation.getOperator() + " " +
                    equation.getNum2() + "\t=");
        }
    }

    //打印答案
    private static void printResults(Iterable<IEquation> equations) {
        Iterator<IEquation> iterator = equations.iterator();
        //题号
        int index = 1;
        while (iterator.hasNext()) {
            IEquation equation = iterator.next();
            System.out.println((index++) + ":\t" + equation.calculate());
        }
    }
}
