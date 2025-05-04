package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GradeStudentsTest {
  private final GradeStudents systemUnderTest = new GradeStudents();

  static Stream<Arguments> roundingGradesTestCases() {
    return Stream.of(
        Arguments.of(
            List.of(73, 67, 38, 33),
            List.of(75, 67, 40, 33)
        ));
  }

  @ParameterizedTest(name = "`{0}` rounded should be {1}")
  @MethodSource("roundingGradesTestCases")
  void should_calculate_diagonal_difference(List<Integer> grades, List<Integer> expectedRoundedGrades) {
    var actualRoundedGrades = systemUnderTest.gradingStudents(grades);

    assertThat(actualRoundedGrades).containsExactlyElementsOf(expectedRoundedGrades);
  }
}