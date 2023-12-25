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

public class SubEquationTests {
    private SubEquation.SubEquationBuilder builder;

    @BeforeEach
    void init() {
        builder = new SubEquation.SubEquationBuilder();
        System.out.println("init annotatted with @BeforeEach");

    }

    @Test
    @DisplayName("A basic assert")
    void useCodedValue() {
        assertEquals(1,
                builder.operand1((short) 3).operand2((short) 2).operator().build().calculate(), " 3 - 2  should equal 1");
    }

    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "5, 3, 2",
            "3, 3, 0"
    })
    void useCsvSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult,
                builder.operand1((short) first).operand2((short) second).operator().build().calculate(),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "using ValueSource")
    @ValueSource(ints = { 7, 3, 4})
    void useValueSource(int argument) {
        assertTrue(argument > 0 && argument < 8);
    }

    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void useRepeatedTest() {
        assertEquals(4,
                builder.operand1((short) 9).operand2((short) 5).operator().build().calculate(), "9 - 5 should equal 4");
    }

    @ParameterizedTest(name = "using MethodSource")
    @MethodSource("equationProvider")
    void useMethodSource(SubEquationTests.SimpleTriplet triplet) {
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

    public static Set<SubEquationTests.SimpleTriplet> equationProvider() {
        Set<SubEquationTests.SimpleTriplet> set = new HashSet<>();
        set.add(new SubEquationTests.SimpleTriplet(0, 0, 0));
        set.add(new SubEquationTests.SimpleTriplet(1, 0, 1));
        return set;
    }

    @Test
    @DisplayName("using assert*** methods")
    void useAssert() {
        assertEquals(2,
                builder.operand1((short) 5).operand2((short) 3).operator().build().calculate(), "5 - 3 should equal 2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown annotatted with @AfterEach");
    }
}
