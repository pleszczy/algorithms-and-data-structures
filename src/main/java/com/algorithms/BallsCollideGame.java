package com.algorithms;

import java.util.ArrayDeque;
import java.util.List;

/**
 * directions:
 * -1 - left
 * 1 - right
 * <p>
 * If balls collide, the ball with lower strength gets destroyed
 * <p>
 * Return indexes of the remaining balls
 */
public class BallsCollideGame {

  public List<Integer> ballsCollide(List<Integer> directions, List<Integer> strengths) {
    var remainingBalls = new ArrayDeque<RemainingBall>();

    for (var i = 0; i < directions.size(); i++) {
      var remainingBall = remainingBalls.peekLast();
      var newBall = new RemainingBall(i, directions.get(i), strengths.get(i));

      if (remainingBall == null) {
        remainingBalls.addLast(newBall);
        continue;
      }

      while (remainingBall != null && remainingBall.direction() == 1 && directions.get(i) == -1) {
        if (remainingBall.strength() < strengths.get(i)) {
          remainingBalls.removeLast();
          remainingBall = remainingBalls.peekLast();
        } else {
          newBall = null;
          break;
        }
      }

      if (newBall != null) {
        remainingBalls.addLast(newBall);
      }
    }

    return remainingBalls.stream()
        .map(RemainingBall::index)
        .toList();
  }

  record RemainingBall(int index, Integer direction, Integer strength) {
  }
}
