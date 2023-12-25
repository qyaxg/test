package com.example.project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 算式集合类
class EquationCollection implements Iterable<IEquation> {
    Set<IEquation> equations = new HashSet<>();

    void generate(int n, EquationChecker checker) {
        EquationFactory factory = new EquationFactory();
        for (int i = 0; i < n; i++) {
            IEquation equation;
            do {
                equation = factory.getEquationRandom();
            } while (!checker.check(equation) || equations.contains(equation));
            equations.add(equation);
        }
    }

    @Override
    public Iterator<IEquation> iterator() {
        return equations.iterator();
    }
}
