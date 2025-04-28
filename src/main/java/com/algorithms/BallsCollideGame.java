package com.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * directions:
 * -1 - left
 *  1 - right
 * <p>
 * If balls collide, the ball with lower strength gets destroyed
 * <p>
 * Return indexes of the remaining balls
 */
public class BallsCollideGame {

  public List<Integer> ballsCollide(List<Integer> directions, List<Integer> strengths) {
    Deque<RemainingBall> remainingBalls = new ArrayDeque<>();

    for (var i = 0; i < directions.size(); i++) {
      // TODO: iterate over all remaining balls
      var remainingBall = remainingBalls.peekLast();
      if (remainingBall == null) {
        remainingBalls.addLast(new RemainingBall(i, directions.get(i), strengths.get(i)));
        continue;
      }

      if (remainingBall.direction == 1 && directions.get(i) == -1) {
        if (remainingBall.strength < strengths.get(i)) {
          remainingBalls.removeLast();
          remainingBalls.addLast(new RemainingBall(i, directions.get(i), strengths.get(i)));
        }
      } else {
        remainingBalls.addLast(new RemainingBall(i, directions.get(i), strengths.get(i)));
      }
    }

    return remainingBalls.stream()
        .map(RemainingBall::index)
        .toList();
  }

  record RemainingBall(Integer index, Integer direction, Integer strength) {
  }
}
