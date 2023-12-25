package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquationCheckerOfRangeTests {

    @BeforeEach
    void init() {
        System.out.println("init annotatted with @BeforeEach");
    }
    // 使用 min=0 和 max=100 创建 EquationCheckerOfRange 的实例进行测试
    private final EquationChecker equationChecker = new EquationCheckerOfRange(0, 100);

    // 使用基本断言的测试方法
    @Test
    @DisplayName("A basic assert")
    void basicAssertTest() {
        assertTrue(equationChecker.check(new MockEquation(10, 20)));
    }

    // 使用 CsvSource 的测试方法
    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "5, 10",
            "15, 30",
            "50, 50"
    })
    void csvSourceTest(int num1, int num2) {
        assertTrue(equationChecker.check(new MockEquation(num1, num2)));
    }

    // 使用 ValueSource 的测试方法
    @ParameterizedTest(name = "using ValueSource")
    @ValueSource(ints = { 5, 10, 15 })
    void valueSourceTest(int num1) {
        assertTrue(equationChecker.check(new MockEquation(num1, 20)));
    }

    // 使用 RepeatedTest 的测试方法
    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void repeatedTest() {
        assertTrue(equationChecker.check(new MockEquation(10, 30)));
    }

    // 使用 assert*** 方法的测试方法
    @Test
    @DisplayName("using assert*** methods")
    void assertMethodsTest() {
        assertTrue(equationChecker.check(new MockEquation(50, 50)));
    }

    // 用于测试目的的 IEquation 的模拟实现
    private static class MockEquation implements IEquation {
        private final int num1;
        private final int num2;

        public MockEquation(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int getNum1() {
            return num1;
        }

        @Override
        public int getNum2() {
            return num2;
        }

        @Override
        public char getOperator() {
            return 0;
        }

        @Override
        public void setNum1(short num1) {

        }

        @Override
        public void setNum2(short num2) {

        }

        @Override
        public void setOperator(char operator) {

        }

        @Override
        public int calculate() {
            return num1 + num2; // 根据需要修改计算
        }
    }
    @AfterEach
    void tearDown() {
        System.out.println("tearDown annotatted with @AfterEach");
    }
}
