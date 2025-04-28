package com.algorithms;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Alex and Charlie are playing an online video game.
 * Initially, there are m players in the first level, and there are next n levels.
 * Each level introduces a new player (along with the players from the previous level).
 * Each player has some strength that determines the difficulty of beating this player.
 * To pass any level, select any available players and beat them.
 * Alex has completed the game and beaten the rank-th strongest player at every level.
 * Now it's Charlie's turn to play. Whenever a player is beaten, Charlie's health decreases by the amount of strength of that player.
 * So the initial health of Charlie must be greater than or equal to the sum of the strengths of players that are beaten throughout the game.
 * What is the minimum initial health that Charlie needs to start with in order to do this?
 * Example: initial_players=[1, 2], new_players=[3,4], rank=2
 * Charlie needs to beat the 2nd strongest player at each level.
 * For the first level, players have strengths 1 and 2, so Charlie needs to beat the player with strength 1.
 * For the second level, strengths are 1, 2, and 3, so Charlie defeats strength 2.
 * For the third level, strengths are 1, 2, 3, and 4, so Charlie defeats strength 3. Total health needed = 1 + 2 + 3 = 6.
 */
public class MinimumHealth {

  public int minimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
    var playersInGame = new TreeSet<Integer>(Comparator.reverseOrder());
    playersInGame.addAll(initial_players);
    var minimumHealth = getRankedPlayer(playersInGame, rank);

    for (var player : new_players) {
      playersInGame.add(player);
      minimumHealth += getRankedPlayer(playersInGame, rank);
    }
    return minimumHealth;
  }

  private Integer getRankedPlayer(TreeSet<Integer> playersInGame, int rank) {
    var iterator = playersInGame.iterator();
    for (var currentRank = 1; currentRank <= rank; currentRank++) {
      var player = iterator.next();
      if (currentRank == rank) {
        return player;
      }
    }
    throw new IllegalArgumentException("Rank is out of bounds");
  }

  private Integer getRankedPlayerUsingStreams(TreeSet<Integer> playersInGame, int rank) {
    return playersInGame.stream()
        .skip(rank - 1)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Rank is out of bounds"));
  }
}
