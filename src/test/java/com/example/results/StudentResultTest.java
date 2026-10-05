package com.example.results;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StudentResultTest {
    private final StudentResult result = new StudentResult();
    @Test
    void calculatesTotal() {
        assertEquals(245, result.calculateTotal(new int[]{80, 75, 90}));
    }
    @Test
    void calculatesFractionalAverage() {
        assertEquals(81.6666667,
                result.calculateAverage(new int[]{80, 75, 90}), 0.000001);
    }
    @Test
    void passesWhenEverySubjectMeetsMinimum() {
        assertTrue(result.hasPassed(new int[]{80, 75, 90}));
    }
    @Test
    void passesAtExactBoundary() {
        assertTrue(result.hasPassed(new int[]{40, 40, 40}));
    }
    @Test
    void failsEvenWithHighAverageIfOneSubjectIsBelow40() {
        assertFalse(result.hasPassed(new int[]{100, 100, 39}));
    }
    @Test
    void acceptsZeroAndHundred() {
        assertEquals(100, result.calculateTotal(new int[]{0, 100}));
        assertEquals(50.0, result.calculateAverage(new int[]{0, 100}), 0.000001);
    }
    @Test
    void rejectsEmptyInput() {
        assertThrows(IllegalArgumentException.class,
                () -> result.calculateAverage(new int[]{}));
    }
    @Test
    void rejectsNullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> result.calculateTotal(null));
    }
    @Test
    void rejectsNegativeMarks() {
        assertThrows(IllegalArgumentException.class,
                () -> result.calculateTotal(new int[]{80, -1}));
    }
    @Test
    void rejectsMarksAboveHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> result.hasPassed(new int[]{101, 80}));
    }
}
