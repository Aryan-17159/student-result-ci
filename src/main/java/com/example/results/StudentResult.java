package com.example.results;

/** Each subject is marked out of 100; passing requires 40 in every subject. */
public class StudentResult {
    public int calculateTotal(int[] marks) {
        validateMarks(marks);
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAverage(int[] marks) {
        return (double) calculateTotal(marks) / marks.length;
    }

    public boolean hasPassed(int[] marks) {
        validateMarks(marks);
        for (int mark : marks) {
            if (mark < 40) {
                return false;
            }
        }
        return true;
    }

    private void validateMarks(int[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Provide at least one subject mark.");
        }
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }
        }
    }

    public static void main(String[] args) {
        StudentResult result = new StudentResult();
        int[] marks = {80, 75, 90};
        System.out.println("Student Result Management");
        System.out.println("Total: " + result.calculateTotal(marks));
        System.out.printf("Average: %.2f%n", result.calculateAverage(marks));
        System.out.println("Result: " + (result.hasPassed(marks) ? "PASS" : "FAIL"));
    }
}
