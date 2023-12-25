package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEquationTests {

    private AddEquation.AddEquationBuilder builder;

    @BeforeEach
    void init() {
        builder = new AddEquation.AddEquationBuilder();
        System.out.println("init annotatted with @BeforeEach");

    }

    @Test
    @DisplayName("A basic assert")
    void useCodedValue() {
        assertEquals(2,
                builder.operand1((short) 1).operand2((short) 1).operator().build().calculate(), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3"
    })
    void useCsvSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult,
                builder.operand1((short) first).operand2((short) second).operator().build().calculate(),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "using ValueSource")
    @ValueSource(ints = { 1, 2, 3})
    void useValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void useRepeatedTest() {
        assertEquals(2,
                builder.operand1((short) 1).operand2((short) 1).operator().build().calculate(), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "using MethodSource")
    @MethodSource("equationProvider")
    void useMethodSource(SimpleTriplet triplet) {
        assertEquals(triplet.result,
                builder.operand1((short) triplet.op1).operand2((short) triplet.op2).operator().build().calculate(),
                "should equal");
    }

    public static class SimpleTriplet {
        public int op1;
        public int op2;
        public int result;

        public SimpleTriplet(int op1, int op2, int result) {
            this.op1 = op1;
            this.op2 = op2;
            this.result = result;
        }
    }

    public static Set<AddEquationTests.SimpleTriplet> equationProvider() {
        Set<AddEquationTests.SimpleTriplet> set = new HashSet<>();
        set.add(new AddEquationTests.SimpleTriplet(0, 0, 0));
        set.add(new AddEquationTests.SimpleTriplet(0, 1, 1));
        return set;
    }

    @Test
    @DisplayName("using assert*** methods")
    void useAssert() {
        assertEquals(2,
                builder.operand1((short) 1).operand2((short) 1).operator().build().calculate(), "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("using assertJ methods")
    void useAssertJ() {
        assertThat("www.ncwu.edu.cn").isNotNull()
                .startsWith("www")
                .contains("ncwu")
                .endsWith("cn");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown annotatted with @AfterEach");
    }

}
