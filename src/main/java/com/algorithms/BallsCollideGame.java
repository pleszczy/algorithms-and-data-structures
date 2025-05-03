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
    var remainingBalls = new ArrayDeque<Ball>();

    for (var i = 0; i < directions.size(); i++) {
      var topBall = remainingBalls.peekLast();
      var direction = directions.get(i);
      var strength = strengths.get(i);
      var currentBall = new Ball(i, direction, strength);

      while (topBall != null && topBall.direction() == 1 && direction == -1) {
        if (topBall.strength() < strength) {
          remainingBalls.removeLast();
          topBall = remainingBalls.peekLast();
        } else {
          currentBall = null;
          break;
        }
      }

      if (currentBall != null) {
        remainingBalls.addLast(currentBall);
      }
    }

    return remainingBalls.stream()
        .map(Ball::index)
        .toList();
  }

  record Ball(int index, int direction, int strength) {
  }
}
