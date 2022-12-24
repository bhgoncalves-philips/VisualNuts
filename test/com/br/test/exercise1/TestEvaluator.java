package com.br.test.exercise1;

import com.br.app.exercise1.Evaluator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestEvaluator {
    private final Evaluator evaluator;

    public TestEvaluator() {
        evaluator = new Evaluator(8000);
    }

    @Test
    public void validateEvaluatedMultipleOf3() {
        assertTrue(evaluator.getMeaningfulNumberDescription(9).trim().equalsIgnoreCase(Evaluator.VISUAL));
    }

    @Test
    public void validateEvaluatedMultipleOf5() {
        assertTrue(evaluator.getMeaningfulNumberDescription(20).trim().equalsIgnoreCase(Evaluator.NUTS));
    }

    @Test
    public void validateEvaluatedMultipleOf15() {
        assertTrue(evaluator.getMeaningfulNumberDescription(45).trim().equalsIgnoreCase(Evaluator.VISUAL + Evaluator.SPACE + Evaluator.NUTS));
    }

    @Test
    public void validateEvaluatedMultipleOfNone() {
        assertTrue(evaluator.getMeaningfulNumberDescription(17).trim().equalsIgnoreCase("17"));
    }

    @Test
    public void validateCompleteOutputForMultiplesOf3() {
        int index = 1;
        for (String s : this.evaluator.getNumberDescriptionUntilMaximumValue()) {
            if (index % 3 == 0) {
                assertTrue(s.contains(Evaluator.VISUAL));
            }
            index++;
        }
    }

    @Test
    public void validateCompleteOutputForMultiplesOf5() {
        int index = 1;
        for (String s : this.evaluator.getNumberDescriptionUntilMaximumValue()) {
            if (index % 5 == 0) {
                assertTrue(s.contains(Evaluator.NUTS));
            }
            index++;
        }
    }

    @Test
    public void validateCompleteOutputForMultiplesOf15() {
        int index = 1;
        for (String s : this.evaluator.getNumberDescriptionUntilMaximumValue()) {
            if (index % 15 == 0) {
                assertTrue(s.equals(Evaluator.VISUAL + Evaluator.SPACE + Evaluator.NUTS));
            }
            index++;
        }
    }
}
