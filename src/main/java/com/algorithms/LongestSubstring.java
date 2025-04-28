package com.algorithms;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces
 */
public class LongestSubstring {

  public int longestSubstring(String input) {
    if (input == null || input.isBlank()) {
      return 0;
    }

    var lastSeen = new int[28];
    var currentLongestSubstring = 0;
    var longestSubstringSeen = 0;

    for (char it : input.toCharArray()) {
      var idx = it - 'a';
      if (idx >= 0 && idx < lastSeen.length) {
        if (lastSeen[idx] == 0) {
          lastSeen[idx]++;
          currentLongestSubstring++;
          if (currentLongestSubstring > longestSubstringSeen) {
            longestSubstringSeen = currentLongestSubstring;
          }
        } else {
          lastSeen = new int[28];
          currentLongestSubstring = 0;
        }
      }
    }
    return longestSubstringSeen;
  }
}
