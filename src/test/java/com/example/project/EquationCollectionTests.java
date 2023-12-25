package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquationCollectionTests {
    @BeforeEach
    void init() {

        System.out.println("init annotatted with @BeforeEach");

    }
    @Test
    @DisplayName("直接测试生成方程式的个数")
    void testEquationGenerationCount() {
        EquationCollection equationCollection = new EquationCollection();
        EquationChecker mockChecker = equation -> true; // 例子中的模拟检查器，这里简单返回true
        int numberOfEquationsToGenerate = 5;

        equationCollection.generate(numberOfEquationsToGenerate, mockChecker);

        // 测试生成的方程式个数是否符合预期
        assertEquals(numberOfEquationsToGenerate, equationCollection.equations.size());
    }
    @ParameterizedTest(name = "测试生成方程式的个数: {0} 个")
    @CsvSource({
            "1, 1",
            "5, 5",
            "10, 10",
            "0, 0",
            "3, 3"
    })
    void testEquationGenerationCount(int numberOfEquationsToGenerate, int expectedSize) {
        EquationCollection equationCollection = new EquationCollection();
        EquationChecker mockChecker = equation -> true; // 模拟检查器始终返回 true

        equationCollection.generate(numberOfEquationsToGenerate, mockChecker);

        // 测试生成的方程式个数是否符合预期
        assertEquals(expectedSize, equationCollection.equations.size());
    }
    @RepeatedTest(value = 5, name = "使用重复测试生成方程式的个数")
    void testRepeatedEquationGenerationCount(RepetitionInfo repetitionInfo) {
        EquationCollection equationCollection = new EquationCollection();
        EquationChecker mockChecker = equation -> true; // 例子中的模拟检查器，这里简单返回true

        equationCollection.generate(repetitionInfo.getCurrentRepetition(), mockChecker);

        // 测试生成的方程式个数是否符合预期
        assertEquals(repetitionInfo.getCurrentRepetition(), equationCollection.equations.size());
    }

    @ParameterizedTest(name = "使用参数化测试生成方程式的个数: {0}")
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEquationGenerationCountWithParameters(int numberOfEquationsToGenerate) {
        EquationCollection equationCollection = new EquationCollection();
        EquationChecker mockChecker = equation -> true; // 例子中的模拟检查器，这里简单返回true

        equationCollection.generate(numberOfEquationsToGenerate, mockChecker);

        // 测试生成的方程式个数是否符合预期
        assertEquals(numberOfEquationsToGenerate, equationCollection.equations.size());
    }


    @Test
    @DisplayName("using assert*** methods")
    void testEquationGenerationCountWithParameters() {
        // 创建 EquationCollection 实例
        EquationCollection equationCollection = new EquationCollection();

        // 创建 EquationChecker 实例，这里简化为始终返回 true
        EquationChecker mockChecker = equation -> true;

        // 参数化生成方程式，期望生成 7 个方程式
        equationCollection.generate(7, mockChecker);

        // 使用断言方法测试生成的方程式个数是否符合预期
        assertEquals(7, equationCollection.equations.size());
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown annotatted with @AfterEach");
    }
}
