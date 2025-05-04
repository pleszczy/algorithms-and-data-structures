package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * HackerRank: <a href="https://www.hackerrank.com/challenges/grading/problem">grading students</a>
 * <p>
 * HackerLand University has the following grading policy:
 * <ul>
 *   <li>Every student receives a grade in the inclusive range from 0 to 100.</li>
 *   <li>Any grade less than 40 is a failing grade.</li>
 * </ul>
 * <p>
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 * <ul>
 *   <li>If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.</li>
 *   <li>If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.</li>
 * </ul>
 *
 * <p><strong>Examples:</strong></p>
 * <pre>
 * grade = 84 → round to 85 (85 - 84 = 1, less than 3)
 * grade = 29 → do not round (result is less than 38)
 * grade = 57 → do not round (60 - 57 = 3, not less than 3)
 * </pre>
 *
 * <p>Given the initial value of {@code grade} for each of Sam's students, this method automates the rounding process.</p>
 *
 * <p><strong>Constraints:</strong></p>
 * <ul>
 *   <li>1 ≤ grades.size() ≤ 60</li>
 *   <li>0 ≤ grades[i] ≤ 100</li>
 * </ul>
 *
 * <p><strong>Sample Input:</strong></p>
 * <pre>
 * 4
 * 73
 * 67
 * 38
 * 33
 * </pre>
 *
 * <p><strong>Sample Output:</strong></p>
 * <pre>
 * 75
 * 67
 * 40
 * 33
 * </pre>
 * <p>
 *  @param grades a list of student grades before rounding
 *  @return a list of grades after rounding, following HackerLand's grading policy
 */
public class GradeStudents {
  public List<Integer> gradingStudents(List<Integer> grades) {
    var roundedGrades = new ArrayList<Integer>(grades.size());
    for (var grade : grades) {
      if (grade < 38) {
        roundedGrades.add(grade);
        continue;
      }
      var modulo5 = grade % 5;
      if (modulo5 >= 3) {
        roundedGrades.add(grade + 5 - modulo5);
        continue;
      }
      roundedGrades.add(grade);
    }
    return roundedGrades;
  }
}
